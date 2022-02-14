package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Niveau;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Semestre;
import tn.suptech.examenahmedmannainumero_sujetv.services.NiveauService;
import tn.suptech.examenahmedmannainumero_sujetv.services.SemestreService;

import java.util.List;

@RestController
@RequestMapping(path="/gestionSemestre")
public class SemestreController {
    private SemestreService _semestreService ;

    public SemestreController(SemestreService semestreService) {
        this._semestreService = semestreService;
    }

    @RequestMapping(path = "/semestres")
    public List<Semestre> getAllSemestre(){
        return  _semestreService.getAll();
    }
    @RequestMapping(path = "/semestre/{id}")
    public Semestre getSemestreByID(@PathVariable Long id){
        return  _semestreService.getOne(id);
    }
    @PostMapping(path = "/semestre")
    public Semestre createSemestre(@RequestBody Semestre semestre){
        return  _semestreService.add(semestre);
    }

    @PutMapping(path = "/semestre")
    public Semestre UpdateSemestre(@RequestBody Semestre semestre){
        return  _semestreService.update(semestre);
    }

    @DeleteMapping (path = "/semestre/{id}")
    public Semestre deleteSemestre(@PathVariable Long id){
        return  _semestreService.delete(id);
    }

}
