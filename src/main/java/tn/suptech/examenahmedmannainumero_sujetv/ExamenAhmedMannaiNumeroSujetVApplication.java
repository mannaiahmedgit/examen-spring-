package tn.suptech.examenahmedmannainumero_sujetv;

import com.itextpdf.text.DocumentException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.suptech.examenahmedmannainumero_sujetv.entities.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Module;
import tn.suptech.examenahmedmannainumero_sujetv.services.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class ExamenAhmedMannaiNumeroSujetVApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenAhmedMannaiNumeroSujetVApplication.class, args);

    }
    @Bean
    CommandLineRunner start(UserService userService,
                            NiveauService niveauService,
                            SemestreService semestreService,
                            ModuleService moduleService,
                            MatiereService matiereService,
                            ClasseService classeService,
                            EleveClasseService eleveClasseService,
                            EnseignantMatiereClasseService enseignantMatiereClasseService,
                            ExamenService examenService,
                            ExamenClassService examenClassService,
                            NoteService noteService,
                            GenerationPdfService generationPdfService,
                           EmailSenderService emailSenderService ) throws DocumentException, IOException {
        return args->{

            userService.add(new Admnistrateur("Ahmed", "Mannai", "ahmed55", "123", "mannai.ahmed55@gmail.com"));

            //ajout des eleves
            userService.add(new Eleve("anis", "masoudi", "anis55", "123", "anis.masoudi@gmail.com",123456789L));
            userService.add(new Eleve("tawfik", "belghith", "tawfik55", "123", "tawfik.belghith@gmail.com",441235789L));
            userService.add(new Eleve("karim", "hasouni", "karim55", "123", "karim.hasouni@gmail.com",251235789L));
            userService.add(new Eleve("tarek", "gamoudi", "tarek55", "123", "tarek.gamoudi@gmail.com",451235789L));
            userService.add(new Eleve("faycel", "twati", "faycel55", "123", "faycel.twati@gmail.com",581235789L));









            userService.add(new Enseignant("chaker", "toujeni", "chaker55", "123", "chaker.toujeni@gmail.com",07422514L));
            userService.add(new Enseignant("fawzi", "hedfi", "fawzi55", "123", "fawzi.hedfi@gmail.com",02422514L));



            //ajout des niveau

            niveauService.add(new Niveau(null,"1er ingenieur",null));
            niveauService.add(new Niveau(null,"2emme ingenieur",null));
            niveauService.add(new Niveau(null,"3emme ingenieur",null));

            //ajout des semestre

            semestreService.add(new Semestre(null,"Semestre1",niveauService.getOne(1L)));
            semestreService.add(new Semestre(null,"Semestre2",niveauService.getOne(1L)));
            semestreService.add(new Semestre(null,"Semestre3",niveauService.getOne(2L)));
            semestreService.add(new Semestre(null,"Semestre4",niveauService.getOne(2L)));
            semestreService.add(new Semestre(null,"Semestre5",niveauService.getOne(3L)));
            semestreService.add(new Semestre(null,"Semestre6",niveauService.getOne(3L)));


            moduleService.add(new Module(null,"Mathématiques",semestreService.getOne(1L)));
            moduleService.add(new Module(null,"Algorithmique et Programmation",semestreService.getOne(1L)));
            moduleService.add(new Module(null,"Développement Web",semestreService.getOne(1L)));
            moduleService.add(new Module(null,"Conception",semestreService.getOne(1L)));

            moduleService.add(new Module(null,"Mathématiques2",semestreService.getOne(2L)));
            moduleService.add(new Module(null,"Programmation Avancée",semestreService.getOne(2L)));
            moduleService.add(new Module(null,"Développement Web Objet",semestreService.getOne(2L)));
            moduleService.add(new Module(null,"bases de donnees",semestreService.getOne(2L)));


            //ajout des matieres

            matiereService.add(new Matiere(null,"Mathématique de l'ingénieur 1",1.5,moduleService.getOne(1L)));
            matiereService.add(new Matiere(null,"Algorithme ",3,moduleService.getOne(2L)));
            matiereService.add(new Matiere(null,"Programmation C ",3,moduleService.getOne(2L)));
            matiereService.add(new Matiere(null,"Developement Web  ",3,moduleService.getOne(3L)));
            matiereService.add(new Matiere(null,"Cour Javascript  ",3,moduleService.getOne(3L)));
            matiereService.add(new Matiere(null,"Uml",1.5,moduleService.getOne(4L)));
            matiereService.add(new Matiere(null,"base de donnees",1.5,moduleService.getOne(4L)));

            matiereService.add(new Matiere(null,"Mathématique de l'ingénieur 2",3,moduleService.getOne(5L)));
            matiereService.add(new Matiere(null,"Statistique inférentielle",1.5,moduleService.getOne(5L)));


            matiereService.add(new Matiere(null,"Complexité des algorithmes et graphes",2,moduleService.getOne(6L)));
            matiereService.add(new Matiere(null,"Algorithmique avancée",3,moduleService.getOne(6L)));


            matiereService.add(new Matiere(null,"Programmationorientée objet ",3,moduleService.getOne(7L)));
            matiereService.add(new Matiere(null,"Développement Web avancé ",3,moduleService.getOne(7L)));

            matiereService.add(new Matiere(null,"SGBD",3,moduleService.getOne(8L)));

           // ajout des classe

            classeService.add(new Classe(null,"GI101S01",semestreService.getOne(1L)));
            classeService.add(new Classe(null,"GI101S02",semestreService.getOne(2L)));


            //affecter les eleves a les classe

           /* userService.getAll().forEach(u->{
                if(u.getClass().equals(Eleve.class)){
                    eleveClasseService.add(new EleveClass(null,classeService.getOne(1L),(Eleve) u));
                    eleveClasseService.add(new EleveClass(null,classeService.getOne(2L),(Eleve) u));
                }
            });*/

            userService.getAll().stream().filter(u->u.getClass().equals(Eleve.class)).forEach(e->{
                eleveClasseService.add(new EleveClass(null,classeService.getOne(1L),(Eleve) e));
                eleveClasseService.add(new EleveClass(null,classeService.getOne(2L),(Eleve) e));
            });

            //affecter les enseignant a des matieres et a les classes

            classeService.getAll().forEach(c->{
                c.getSemestre().getModules().forEach(m->{
                    m.getMatiers().forEach(mat->{
                        List<User> enseignants =  userService.getAll().stream().filter(e->e.getClass().equals(Enseignant.class)).collect(Collectors.toList());
                        Random rand = new Random();
                        enseignantMatiereClasseService.add(new EnseignantMatiereClass(null,
                                                            c,
                                (Enseignant) userService.getOne(enseignants.get(rand.nextInt(enseignants.size())).getId()),
                                                            mat));
                    });
                });
            });

            //creation des examen
           matiereService.getAll().forEach(mat->{
               examenService.add(new Examen(null,"examen de"+mat.getLibelleeMatiere(),new Date(),mat));
           });

           //affecter les examen a les class

           examenService.getAll().forEach(examen -> {
               if(examen.getMatiere().getModule().getSemestre().getId()==1){
                   examenClassService.add(new ExamenClasse(null,examen,classeService.getOne(1L)));
               }
               if(examen.getMatiere().getModule().getSemestre().getId()==2){
                   examenClassService.add(new ExamenClasse(null,examen,classeService.getOne(2L)));
               }
           });


           //saisie des notes

            examenClassService.getAll().forEach(ec->{
                List<Eleve> eleves = new ArrayList<Eleve>() ;

                ec.getClasse().getElevesClasses().forEach(eleveClass -> {
                    eleves.add(eleveClass.getEleve());
                });
                Matiere matiere= ec.getExamen().getMatiere();

                Enseignant enseignant= enseignantMatiereClasseService.getAll()
                        .stream()
                        .filter(emc->emc.getMatiere().getId().equals(matiere.getId()) && emc.getClasse().getId().equals(ec.getClasse().getId()))
                        .collect(Collectors.toList()).get(0).getEnseignant();

                Random rand= new Random();
                eleves.forEach(e->{
                    noteService.add(new Note(null,rand.nextInt(21),ec,enseignant,e));
                });


            });
            Eleve eleve= (Eleve) userService.getOne(2L);
            Niveau niveau = niveauService.getOne(1L);
           // generationPdfService.hello(eleve,niveau);

        //   emailSenderService.sendEmail("ahmed.manai@alphaetiquettes.com","test spring","body test");

        };


    }


}
