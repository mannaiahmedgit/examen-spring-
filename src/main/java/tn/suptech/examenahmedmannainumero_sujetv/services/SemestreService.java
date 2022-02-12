package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Semestre;
import tn.suptech.examenahmedmannainumero_sujetv.entities.User;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.SemestreRepository;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SemestreService {
    private SemestreRepository _semestreRepository;

    public SemestreService(SemestreRepository _semestreRepository) {
        this._semestreRepository = _semestreRepository;
    }

    public List<Semestre> getAll(){
        return _semestreRepository.findAll();
    }
    public Semestre getOne(Long id){
        return _semestreRepository.findById(id).get();
    }
    public Semestre add(Semestre semestre){
        return  _semestreRepository.save(semestre);
    }

    public Semestre update (Semestre semestre){
        return  _semestreRepository.save(semestre);
    }

    public Semestre delete (Long id ){
        Semestre semestreDeletet=this.getOne(id);
        _semestreRepository.delete(semestreDeletet);
        return  semestreDeletet;
    }
}
