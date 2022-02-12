package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Module;

import tn.suptech.examenahmedmannainumero_sujetv.repositories.ModuleRepository;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ModuleService {
    private ModuleRepository _moduleRepository;

    public ModuleService(ModuleRepository _moduleRepository) {
        this._moduleRepository = _moduleRepository;
    }

    public List<Module> getAll(){
        return _moduleRepository.findAll();
    }
    public Module getOne(Long id){
        return _moduleRepository.findById(id).get();
    }
    public Module add(Module module){
        return  _moduleRepository.save(module);
    }

    public Module update (Module module){
        return  _moduleRepository.save(module);
    }

    public Module delete (Long id ){
        Module moduleDeletet=this.getOne(id);
        _moduleRepository.delete(moduleDeletet);
        return  moduleDeletet;
    }
}
