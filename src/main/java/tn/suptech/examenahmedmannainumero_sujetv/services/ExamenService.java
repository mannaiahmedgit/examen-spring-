package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Examen;

import tn.suptech.examenahmedmannainumero_sujetv.repositories.ExamenRepository;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExamenService {
    private ExamenRepository _examenRepository;

    public ExamenService(ExamenRepository _examenRepository) {
        this._examenRepository = _examenRepository;
    }

    public List<Examen> getAll(){
        return _examenRepository.findAll();
    }
    public Examen getOne(Long id){
        return _examenRepository.findById(id).get();
    }
    public Examen add(Examen examen){
        return  _examenRepository.save(examen);
    }
    public Examen update (Examen examen){
        return  _examenRepository.save(examen);
    }

    public Examen delete (Long id ){
        Examen examenDeletet=this.getOne(id);
        _examenRepository.delete(examenDeletet);
        return  examenDeletet;
    }
}
