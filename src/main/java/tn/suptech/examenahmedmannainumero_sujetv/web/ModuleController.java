package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Module;
import tn.suptech.examenahmedmannainumero_sujetv.services.ModuleService;


import java.util.List;

@RestController
@RequestMapping(path="/api")
public class ModuleController {
    private ModuleService _moduleService;

    public ModuleController(ModuleService _moduleService) {
        this._moduleService = _moduleService;
    }

    @RequestMapping(path = "/modules")
    public List<Module> getAllmodule(){
        return  _moduleService.getAll();
    }
    @RequestMapping(path = "/module/{id}")
    public Module getModuleByID(@PathVariable Long id){
        return  _moduleService.getOne(id);
    }
    @PostMapping(path = "/module")
    public Module createModule(@RequestBody Module module){
        return  _moduleService.add(module);
    }

    @PutMapping(path = "/module")
    public Module UpdateModule(@RequestBody Module module){
        return  _moduleService.update(module);
    }

    @DeleteMapping (path = "/module/{id}")
    public Module deleteeModule(@PathVariable Long id){
        return  _moduleService.delete(id);
    }

}
