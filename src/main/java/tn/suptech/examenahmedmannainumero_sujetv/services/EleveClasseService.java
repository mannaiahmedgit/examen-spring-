package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Classe;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Eleve;
import tn.suptech.examenahmedmannainumero_sujetv.entities.EleveClass;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.ClasseRepository;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.EleveClasseRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EleveClasseService {
    private EleveClasseRepository _eleveClasseRepository;

    public EleveClasseService(EleveClasseRepository _eleveClasseRepository) {
        this._eleveClasseRepository = _eleveClasseRepository;
    }



    public List<EleveClass> getAll(){
        return _eleveClasseRepository.findAll();
    }
    public EleveClass getOne(Long id){
        return _eleveClasseRepository.findById(id).get();
    }
    public EleveClass add(EleveClass eleveClass){
        return  _eleveClasseRepository.save(eleveClass);
    }

    public EleveClass update (EleveClass eleveClass){
        return  _eleveClasseRepository.save(eleveClass);
    }

    public EleveClass delete (Long id ){
        EleveClass eleveClassDeletet=this.getOne(id);
        _eleveClasseRepository.delete(eleveClassDeletet);
        return  eleveClassDeletet;
    }
    public  List<Eleve> getElevesByClass(Classe classe) {
        List<Eleve> eleves= new ArrayList<Eleve>();
         this.getAll().stream().filter(ec->ec.getClasse().getId().equals(classe.getId())).forEach(e->{
            eleves.add(e.getEleve());
        });
        return  eleves;
    }
    public  List<Classe> getClassesByEleve(Eleve eleve) {
        List<Classe> classes= new ArrayList<Classe>();
        this.getAll().stream().filter(ec->ec.getEleve().getId().equals(eleve.getId())).forEach(e->{
            classes.add(e.getClasse());
        });
        return  classes;
    }

}
