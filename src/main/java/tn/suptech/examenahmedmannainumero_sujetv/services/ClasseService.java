package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Classe;
import tn.suptech.examenahmedmannainumero_sujetv.entities.User;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.ClasseRepository;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClasseService {
    private ClasseRepository _classeRepository;

    public ClasseService(ClasseRepository _classeRepository) {
        this._classeRepository = _classeRepository;
    }

    public List<Classe> getAll(){
        return _classeRepository.findAll();
    }
    public Classe getOne(Long id){
        return _classeRepository.findById(id).get();
    }
    public Classe add(Classe classe){
        return  _classeRepository.save(classe);
    }

    public Classe update (Classe classe){
        return  _classeRepository.save(classe);
    }

    public Classe delete (Long id ){
        Classe classeDeletet=this.getOne(id);
        _classeRepository.delete(classeDeletet);
        return  classeDeletet;
    }
}
