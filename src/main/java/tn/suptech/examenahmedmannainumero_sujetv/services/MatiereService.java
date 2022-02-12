package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Matiere;
import tn.suptech.examenahmedmannainumero_sujetv.entities.User;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.MatiereRepository;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MatiereService {
    private MatiereRepository _matiereRepository;

    public MatiereService(MatiereRepository _matiereRepository) {
        this._matiereRepository = _matiereRepository;
    }

    public List<Matiere> getAll(){
        return _matiereRepository.findAll();
    }
    public Matiere getOne(Long id){
        return _matiereRepository.findById(id).get();
    }
    public Matiere add(Matiere matiere){
        return  _matiereRepository.save(matiere);
    }

    public Matiere update (Matiere matiere){
        return  _matiereRepository.save(matiere);
    }

    public Matiere delete (Long id ){
        Matiere matiereDeletet=this.getOne(id);
        _matiereRepository.delete(matiereDeletet);
        return  matiereDeletet;
    }
}
