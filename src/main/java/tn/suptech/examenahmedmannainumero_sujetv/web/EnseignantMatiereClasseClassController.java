package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.EnseignantMatiereClass;
import tn.suptech.examenahmedmannainumero_sujetv.entities.ExamenClasse;
import tn.suptech.examenahmedmannainumero_sujetv.services.EnseignantMatiereClasseService;
import tn.suptech.examenahmedmannainumero_sujetv.services.ExamenClassService;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class EnseignantMatiereClasseClassController {
  private EnseignantMatiereClasseService _enseignantMatiereClasseService;

    @RequestMapping(path = "/ensmatlasses")
    public List<EnseignantMatiereClass> getAllEnseignantMatiereClass(){
        return  _enseignantMatiereClasseService.getAll();
    }
    @RequestMapping(path = "/ensmatclasse/{id}")
    public EnseignantMatiereClass getEnseignantMatiereClassByID(@PathVariable Long id){
        return  _enseignantMatiereClasseService.getOne(id);
    }
    @PostMapping(path = "/encmatclasse")
    public EnseignantMatiereClass createEnseignantMatiereClass(@RequestBody EnseignantMatiereClass enseignantMatiereClass){

        return  _enseignantMatiereClasseService.add(enseignantMatiereClass);
    }

    @PutMapping(path = "/encmatclasse")
    public EnseignantMatiereClass UpdateEnseignantMatiereClass(@RequestBody EnseignantMatiereClass enseignantMatiereClass){
        return  _enseignantMatiereClasseService.update(enseignantMatiereClass);
    }

    @DeleteMapping (path = "/encmatclasse/{id}")
    public EnseignantMatiereClass deleteEnseignantMatiereClass(@PathVariable Long id){
        return  _enseignantMatiereClasseService.delete(id);
    }



}
