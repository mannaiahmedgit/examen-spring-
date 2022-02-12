package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Eleve;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Examen;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Note;

import tn.suptech.examenahmedmannainumero_sujetv.repositories.NoteRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NoteService {
    private NoteRepository _noteRepository;

    public NoteService(NoteRepository _noteRepository) {
        this._noteRepository = _noteRepository;
    }

    public List<Note> getAll(){
        return _noteRepository.findAll();
    }
    public Note getOne(Long id){
        return _noteRepository.findById(id).get();
    }
    public Note add(Note note){
        return  _noteRepository.save(note);
    }

    public Note update (Note note){
        return  _noteRepository.save(note);
    }

    public Note delete (Long id ){
        Note noteDeletet=this.getOne(id);
        _noteRepository.delete(noteDeletet);
        return  noteDeletet;
    }
    public  List<Note> getAllNotesByEleve(Eleve eleve){
        return  this.getAll().stream().filter(n->n.getEleve().getId().equals(eleve.getId())).collect(Collectors.toList());
    }
    public  double getNotByExamenetEleve(Examen examen, Eleve eleve){
        return  getAllNotesByEleve(eleve).stream().filter(n->n.getExamenClasse().getExamen().getId().equals(examen.getId())).collect(Collectors.toList()).get(0).getNoteExamen();

    }
}
