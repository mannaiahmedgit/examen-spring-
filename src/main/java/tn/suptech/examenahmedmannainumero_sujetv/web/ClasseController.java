package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Classe;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Matiere;
import tn.suptech.examenahmedmannainumero_sujetv.services.ClasseService;
import tn.suptech.examenahmedmannainumero_sujetv.services.MatiereService;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class ClasseController {
 private ClasseService _classeService;

    public ClasseController(ClasseService classeService) {
        this._classeService = classeService;
    }

    @RequestMapping(path = "/classes")
    public List<Classe> getAllClasse(){
        return  _classeService.getAll();
    }
    @RequestMapping(path = "/classe/{id}")
    public Classe getClassByID(@PathVariable Long id){
        return  _classeService.getOne(id);
    }
    @PostMapping(path = "/classe")
    public Classe createClasse(@RequestBody Classe classe){
        return  _classeService.add(classe);
    }

    @PutMapping(path = "/classe")
    public Classe UpdateClasse(@RequestBody Classe classe){
        return  _classeService.update(classe);
    }

    @DeleteMapping (path = "/classe/{id}")
    public Classe deteClasse(@PathVariable Long id){
        return  _classeService.delete(id);
    }

}
