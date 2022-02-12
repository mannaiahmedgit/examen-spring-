package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Niveau;

import tn.suptech.examenahmedmannainumero_sujetv.repositories.NiveauRepository;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NiveauService {
    private NiveauRepository _niveauRepository;

    public NiveauService(NiveauRepository _niveauRepository) {
        this._niveauRepository = _niveauRepository;
    }

    public List<Niveau> getAll(){
        return _niveauRepository.findAll();
    }
    public Niveau getOne(Long id){
        return _niveauRepository.findById(id).get();
    }
    public Niveau add(Niveau niveau){
        return  _niveauRepository.save(niveau);
    }

    public Niveau update (Niveau niveau){
        return  _niveauRepository.save(niveau);
    }

    public Niveau delete (Long id ){
        Niveau niveauDeletet=this.getOne(id);
        _niveauRepository.delete(niveauDeletet);
        return  niveauDeletet;
    }
}
