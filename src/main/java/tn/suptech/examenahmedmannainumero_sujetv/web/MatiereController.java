package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Matiere;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Module;
import tn.suptech.examenahmedmannainumero_sujetv.services.MatiereService;
import tn.suptech.examenahmedmannainumero_sujetv.services.ModuleService;

import java.util.List;

@RestController
@RequestMapping(path="/gestionMatiere")
public class MatiereController {
  private MatiereService _matiereService;

    public MatiereController(MatiereService _matiereService) {
        this._matiereService = _matiereService;
    }

    @RequestMapping(path = "/matieres")
    public List<Matiere> getAllMatieres(){
        return  _matiereService.getAll();
    }
    @RequestMapping(path = "/matiere/{id}")
    public Matiere getMatiereByID(@PathVariable Long id){
        return  _matiereService.getOne(id);
    }
    @PostMapping(path = "/matiere")
    public Matiere createMatiere(@RequestBody Matiere matiere){
        return  _matiereService.add(matiere);
    }

    @PutMapping(path = "/matiere")
    public Matiere UpdateMatiere(@RequestBody Matiere matiere){
        return  _matiereService.update(matiere);
    }

    @DeleteMapping (path = "/matiere/{id}")
    public Matiere deleteMatiere(@PathVariable Long id){
        return  _matiereService.delete(id);
    }

}
