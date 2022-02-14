package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Classe;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Eleve;
import tn.suptech.examenahmedmannainumero_sujetv.entities.EleveClass;
import tn.suptech.examenahmedmannainumero_sujetv.entities.ExamenClasse;
import tn.suptech.examenahmedmannainumero_sujetv.services.ClasseService;
import tn.suptech.examenahmedmannainumero_sujetv.services.EleveClasseService;
import tn.suptech.examenahmedmannainumero_sujetv.services.ExamenClassService;
import tn.suptech.examenahmedmannainumero_sujetv.services.UserService;

import java.util.List;

@RestController
@RequestMapping(path="/gestionExamenClass")
public class ExamenClassController {
 private ExamenClassService _examenClassService;

    public ExamenClassController(ExamenClassService _examenClassService) {
        this._examenClassService = _examenClassService;
    }

    @RequestMapping(path = "/examenclasses")
    public List<ExamenClasse> getAllExamenClasse(){
        return  _examenClassService.getAll();
    }
    @RequestMapping(path = "/examenclasse/{id}")
    public ExamenClasse getExamenClasseByID(@PathVariable Long id){
        return  _examenClassService.getOne(id);
    }
    @PostMapping(path = "/examenclasse")
    public ExamenClasse createExamenClasse(@RequestBody ExamenClasse examenClasse){

        return  _examenClassService.add(examenClasse);
    }

    @PutMapping(path = "/examenclasse")
    public ExamenClasse UpdateExamenClasse(@RequestBody ExamenClasse examenClasse){
        return  _examenClassService.update(examenClasse);
    }

    @DeleteMapping (path = "/examenclasse/{id}")
    public ExamenClasse deleteExamenClasse(@PathVariable Long id){
        return  _examenClassService.delete(id);
    }



}
