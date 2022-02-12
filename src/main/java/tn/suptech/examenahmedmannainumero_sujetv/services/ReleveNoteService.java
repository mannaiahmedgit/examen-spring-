package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.dto.*;
import tn.suptech.examenahmedmannainumero_sujetv.model.ReleveNote;
import tn.suptech.examenahmedmannainumero_sujetv.entities.*;
import tn.suptech.examenahmedmannainumero_sujetv.model.ReleveNoteAnuelle;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReleveNoteService {
    @Autowired
    private ClasseService classeService;
    @Autowired
    private  EleveClasseService eleveClasseService;
    @Autowired
    private ExamenClassService examenClassService;
    @Autowired
    private  EnseignantMatiereClasseService enseignantMatiereClasseService;
    @Autowired
    private  NoteService  noteService;
    @Autowired
    private  SemestreService semestreService;



    public ReleveNoteService() {

    }
    public DtoEleve mappingEleveEnDtoEleve(Eleve eleve){
        DtoEleve dtoEleve= new DtoEleve();
        dtoEleve.setId(eleve.getId());
        dtoEleve.setNom(eleve.getNom());
        dtoEleve.setPrenom(eleve.getPrenom());
        dtoEleve.setEmail(eleve.getEmail());
        dtoEleve.setNumeroInscription(eleve.getNumeroInscription());
        return  dtoEleve;
    }
    public  DtoClasse mappingClasseDtoClasse(Classe classe){
        DtoClasse dtoClasse = new DtoClasse();
        dtoClasse.setId(classe.getId());
        dtoClasse.setDESCRIPTION(classe.getDESCRIPTION());
        return  dtoClasse;
    }
    public  DtoNiveau mappingNiveauDtoNiveau(Semestre semestre){
        DtoNiveau dtoNiveau = new DtoNiveau();
        dtoNiveau.setId(semestre.getNiveau().getId());
        dtoNiveau.setLibelleeNiveau(semestre.getNiveau().getLibelleeNiveau());
        return dtoNiveau;
    }


    public ReleveNote getReleveNoteByEleve (Eleve eleve, Semestre semestre){
        ReleveNote releveNote= new ReleveNote();
        //Eleve

        releveNote.setEleve(mappingEleveEnDtoEleve(eleve));
        //Clase

        Classe classe= eleveClasseService.getClassesByEleve(eleve).stream().filter(c->c.getSemestre().getId().equals(semestre.getId())).collect(Collectors.toList()).get(0);
        releveNote.setClasse(mappingClasseDtoClasse(classe));
        //niveau
       releveNote.setNiveau(mappingNiveauDtoNiveau(semestre));
        //semestre
        releveNote.getSemestre().setId(semestre.getId());
        releveNote.getSemestre().setLibelleeSemestre(semestre.getLibelleeSemestre());
        List<DtoModule> dtoModuleList = new ArrayList<DtoModule>();
        semestre.getModules().forEach(m->{
            System.out.println(m.getLibelleeModule());
            DtoModule dtoModule= new DtoModule();
            dtoModule.setId(m.getId());
            dtoModule.setLibelleeModule(m.getLibelleeModule());
            List<DtoMatiere> dtoMatiereList= new ArrayList<DtoMatiere>();
            m.getMatiers().forEach(mat->{
                System.out.println(mat.getLibelleeMatiere());
                DtoMatiere dtoMatiere = new DtoMatiere();
                dtoMatiere.setId(mat.getId());
                dtoMatiere.setLibelleeMatiere(mat.getLibelleeMatiere());
                dtoMatiere.setCoeifficient(mat.getCoeifficient());
                Enseignant enseignant=enseignantMatiereClasseService.getEnseignantByClasseAndMatiere(classe,mat);
                DtoEnseignant dtoEnseignant= new DtoEnseignant();
                dtoEnseignant.setId(enseignant.getId());
                dtoEnseignant.setEmail(enseignant.getEmail());
                dtoEnseignant.setNom(enseignant.getNom());
                dtoEnseignant.setPrenom(enseignant.getPrenom());
                dtoEnseignant.setNumeroCarteIdentitee(enseignant.getNumeroCarteIdentitee());
                dtoMatiere.setDtoEnseignant(dtoEnseignant);
                List<Examen> examenList =examenClassService.getExamentByClassetMatiere(classe,mat);
                List<DtoExamen> dtoExamenList = new ArrayList<DtoExamen>();
                examenList.forEach(ex->{
                    DtoExamen dtoExamen= new DtoExamen();
                    dtoExamen.setId(ex.getId());
                    dtoExamen.setDescription(ex.getDescription());
                    dtoExamen.setDate(ex.getDate());
                    dtoExamen.setNote(noteService.getNotByExamenetEleve(ex,eleve));
                    dtoExamenList.add(dtoExamen);
                });
                dtoMatiere.setDtoExamenList(dtoExamenList);

                dtoMatiere.setMoyenneMatiere(dtoMatiere.getDtoExamenList().stream().mapToDouble(val->val.getNote()).average().orElse(0.0));





                dtoMatiereList.add(dtoMatiere);
            });

            dtoModule.setDtoMatiereList(dtoMatiereList);
            Double sommeNote=0.0;
            Double sommeCoef=0.0;
          /*  dtoModule.getDtoMatiereList().forEach(mat->{
                sommeNote=sommeNote+mat.getMoyenneMatiere();
                sommeCoef=sommeCoef+ mat.getCoeifficient();
            });*/
            dtoModule.setMoyenneModule(dtoModule.getDtoMatiereList().stream().mapToDouble(val->val.getMoyenneMatiere()* val.getCoeifficient()).sum()/
                    dtoModule.getDtoMatiereList().stream().mapToDouble(val->val.getCoeifficient()).sum()   );

            System.out.println( "coef : "+dtoModule.getDtoMatiereList().stream().mapToDouble(val->val.getCoeifficient()).sum() );
            dtoModuleList.add(dtoModule);

        });


        releveNote.getSemestre().setDtoModuleList(dtoModuleList);
        releveNote.setMoyenneSemestre(releveNote.getSemestre().getDtoModuleList().stream().mapToDouble(val->val.getMoyenneModule()).average().orElse(0.0));

        return releveNote;
    }
    public ReleveNoteAnuelle getReleveNoteAnuelleByEleve(Eleve eleve,Niveau niveau){
        ReleveNoteAnuelle releveNoteAnuelle= new ReleveNoteAnuelle();
         AtomicInteger i = new AtomicInteger();
         List<ReleveNote> releveNoteList= new ArrayList<ReleveNote>();
         List<Semestre>semestres=semestreService.getAll().stream().filter(s->s.getNiveau().getId().equals(niveau.getId())).collect(Collectors.toList());
       semestres.forEach(s->{
            System.out.println(i.getAndIncrement());
            releveNoteList.add(this.getReleveNoteByEleve(eleve,s));
            releveNoteAnuelle.getReleveNoteList().add(getReleveNoteByEleve(eleve,s));

        });
       releveNoteList.forEach(r->{
           System.out.println(r.getSemestre().getLibelleeSemestre());
       });
        releveNoteAnuelle.getNiveau().setId(niveau.getId());
        releveNoteAnuelle.getNiveau().setLibelleeNiveau(niveau.getLibelleeNiveau());
        releveNoteAnuelle.setEleve(mappingEleveEnDtoEleve(eleve));
        releveNoteAnuelle.setMoyenneAnuelle(releveNoteAnuelle.getReleveNoteList().stream().mapToDouble(val->val.getMoyenneSemestre()).average().orElse(0.0));
        if(releveNoteAnuelle.getMoyenneAnuelle()<10.00){
            releveNoteAnuelle.setResultat("Redouble");
        }
        else
        {

            releveNoteAnuelle.getReleveNoteList().forEach(r->{
                r.getSemestre().getDtoModuleList().forEach(m->{
                    if(m.getMoyenneModule()==0){

                        releveNoteAnuelle.setResultat("Redouble");


                    }
                });
            });
        }
        if(releveNoteAnuelle.getResultat()!="Redouble")
        {
            releveNoteAnuelle.setResultat("Reussit");
        }
        return releveNoteAnuelle;

    }

}
