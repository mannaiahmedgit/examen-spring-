package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Niveau;
import tn.suptech.examenahmedmannainumero_sujetv.services.NiveauService;

import java.util.List;

@RestController
@RequestMapping(path="/gestionNiveau")
public class NiveauController {
    private NiveauService  _niveauService ;

    public NiveauController(NiveauService niveauService) {
        this._niveauService = niveauService;
    }
    @RequestMapping(path = "/niveaux")
    public List<Niveau> getAllNiveau(){
        return  _niveauService.getAll();
    }
    @RequestMapping(path = "/niveau/{id}")
    public Niveau getNiveauByID(@PathVariable Long id){
        return  _niveauService.getOne(id);
    }
    @PostMapping(path = "/niveau")
    public Niveau createNiveau(@RequestBody Niveau niveau){
        return  _niveauService.add(niveau);
    }

    @PutMapping(path = "/niveau")
    public Niveau UpdateNiveau(@RequestBody Niveau niveau){
        return  _niveauService.update(niveau);
    }

    @DeleteMapping (path = "/niveau/{id}")
    public Niveau deleteNiveau(@PathVariable Long id){
        return  _niveauService.delete(id);
    }

}
