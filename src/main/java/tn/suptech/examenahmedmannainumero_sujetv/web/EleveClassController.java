package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Classe;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Eleve;
import tn.suptech.examenahmedmannainumero_sujetv.entities.EleveClass;
import tn.suptech.examenahmedmannainumero_sujetv.services.ClasseService;
import tn.suptech.examenahmedmannainumero_sujetv.services.EleveClasseService;
import tn.suptech.examenahmedmannainumero_sujetv.services.UserService;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class EleveClassController {
 private EleveClasseService _eleveClasseService;
private UserService _userService;
private  ClasseService _classeService;
    public EleveClassController(EleveClasseService eleveClasseService,UserService userService,ClasseService classeService) {
        this._eleveClasseService = eleveClasseService;
        this._userService=userService;
        this._classeService=classeService;
    }

    @RequestMapping(path = "/eleveclasses")
    public List<EleveClass> getAllClasse(){
        return  _eleveClasseService.getAll();
    }
    @RequestMapping(path = "/eleveclasse/{id}")
    public EleveClass getClassByID(@PathVariable Long id){
        return  _eleveClasseService.getOne(id);
    }
    @PostMapping(path = "/eleveclasse")
    public EleveClass createEleveClass(@RequestBody EleveClass eleveClass){
        if(_eleveClasseService.getAll().stream().
                filter(ec->ec.getEleve().getId().equals(eleveClass.getEleve().getId()) && ec.getClasse().getId().equals(eleveClass.getClasse().getId())).count()>0
        )
             throw new  RuntimeException("Eleve deja affecté");
        return  _eleveClasseService.add(eleveClass);
    }

    @PutMapping(path = "/eleveclasse")
    public EleveClass UpdateEleveClass(@RequestBody EleveClass eleveClass){
        return  _eleveClasseService.update(eleveClass);
    }

    @DeleteMapping (path = "/eleveclasse/{id}")
    public EleveClass deleteEleveClass(@PathVariable Long id){
        return  _eleveClasseService.delete(id);
    }

    @RequestMapping(path = "/elevesByclasse/{id}")
    public List<Eleve> getAllEleveByClass(@PathVariable Long id)
    {

        Classe classe= _classeService.getOne(id);
        return  _eleveClasseService.getElevesByClass(classe);
    }
    @RequestMapping(path = "/classesByeleve/{id}")
    public List<Classe> getAllClassByEleve(@PathVariable Long id)
    {
        Eleve eleve ;
                if (_userService.getOne(id).getClass().equals(Eleve.class)) {
                  eleve=  (Eleve) _userService.getOne(id);
                }

                else {
                    throw new RuntimeException("n'est pas un eleve");
                }
        return  _eleveClasseService.getClassesByEleve(eleve);
    }

}
