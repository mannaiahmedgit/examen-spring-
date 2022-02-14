package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Classe;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Examen;
import tn.suptech.examenahmedmannainumero_sujetv.services.ClasseService;
import tn.suptech.examenahmedmannainumero_sujetv.services.ExamenService;

import java.util.List;

@RestController
@RequestMapping(path="/gestionExamen")
public class ExamenController {
private ExamenService _examenService;

    public ExamenController(ExamenService _examenService) {
        this._examenService = _examenService;
    }

    @RequestMapping(path = "/examens")
    public List<Examen> getAllExamen(){
        return  _examenService.getAll();
    }
    @RequestMapping(path = "/examen/{id}")
    public Examen geExamenByID(@PathVariable Long id){
        return  _examenService.getOne(id);
    }
    @PostMapping(path = "/examen")
    public Examen createExamen(@RequestBody Examen examen){
        return  _examenService.add(examen);
    }

    @PutMapping(path = "/examen")
    public Examen UpdateExamen(@RequestBody Examen examen){
        return  _examenService.update(examen);
    }

    @DeleteMapping (path = "/examen/{id}")
    public Examen deleteExamen(@PathVariable Long id){
        return  _examenService.delete(id);
    }

}
