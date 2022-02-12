package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Classe;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Enseignant;
import tn.suptech.examenahmedmannainumero_sujetv.entities.EnseignantMatiereClass;

import tn.suptech.examenahmedmannainumero_sujetv.entities.Matiere;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.EnseignantMatiereClasseRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnseignantMatiereClasseService {
    private EnseignantMatiereClasseRepository _enseignantMatiereClasseRepository;

    public EnseignantMatiereClasseService(EnseignantMatiereClasseRepository _enseignantMatiereClasseRepository) {
        this._enseignantMatiereClasseRepository = _enseignantMatiereClasseRepository;
    }

    public List<EnseignantMatiereClass> getAll(){
        return _enseignantMatiereClasseRepository.findAll();
    }
    public EnseignantMatiereClass getOne(Long id){
        return _enseignantMatiereClasseRepository.findById(id).get();
    }
    public EnseignantMatiereClass add(EnseignantMatiereClass enseignantMatiereClass){
        return  _enseignantMatiereClasseRepository.save(enseignantMatiereClass);
    }

    public EnseignantMatiereClass update (EnseignantMatiereClass enseignantMatiereClass){
        return  _enseignantMatiereClasseRepository.save(enseignantMatiereClass);
    }

    public EnseignantMatiereClass delete (Long id ){
        EnseignantMatiereClass enseignantMatiereClassDeletet=this.getOne(id);
        _enseignantMatiereClasseRepository.delete(enseignantMatiereClassDeletet);
        return  enseignantMatiereClassDeletet;
    }
    public Enseignant getEnseignantByClasseAndMatiere(Classe classe, Matiere matiere){
        return  this.getAll().stream().
                filter(emc->emc.getMatiere().getId().equals(matiere.getId()) && emc.getClasse().getId().equals(classe.getId()))
                .collect(Collectors.toList()).get(0).getEnseignant();
    }
}
