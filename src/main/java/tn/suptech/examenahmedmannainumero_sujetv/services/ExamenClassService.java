package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.*;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.ExamenClasseRepository;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExamenClassService {


  private ExamenClasseRepository _examenClasseRepository;

    public ExamenClassService(ExamenClasseRepository _examenClasseRepository) {
        this._examenClasseRepository = _examenClasseRepository;
    }

    public List<ExamenClasse> getAll(){
        return _examenClasseRepository.findAll();
    }
    public ExamenClasse getOne(Long id){
        return _examenClasseRepository.findById(id).get();
    }
    public ExamenClasse add(ExamenClasse examenClasse){
        return  _examenClasseRepository.save(examenClasse);
    }

    public ExamenClasse update (ExamenClasse examenClasse){
        return  _examenClasseRepository.save(examenClasse);
    }

    public ExamenClasse delete (Long id ){
        ExamenClasse examenClasseDeletet=this.getOne(id);
        _examenClasseRepository.delete(examenClasseDeletet);
        return  examenClasseDeletet;
    }
    public List<Examen> getExamentByClassetMatiere(Classe classe, Matiere matiere){
        List<Examen> examenList = new ArrayList<Examen>();
        this.getAll().stream().filter(ec->ec.getClasse().getId().equals(classe.getId()) && ec.getExamen().getMatiere().getId().equals(matiere.getId())).forEach(e->{
            examenList.add(e.getExamen());
        });
        return  examenList;
    }
}
