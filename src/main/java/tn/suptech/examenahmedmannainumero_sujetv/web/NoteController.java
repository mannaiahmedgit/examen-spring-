package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Classe;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Matiere;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Note;
import tn.suptech.examenahmedmannainumero_sujetv.services.ClasseService;
import tn.suptech.examenahmedmannainumero_sujetv.services.NoteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/gestionNotes")
public class NoteController {
 private NoteService _noteService ;

    public NoteController(NoteService noteService) {
        this._noteService = noteService;
    }

    @RequestMapping(path = "/notes")
    public List<Note> getAllNote(){
        return  _noteService.getAll();
    }
    @RequestMapping(path = "/note/{id}")
    public Note getNoteByID(@PathVariable Long id){
        return  _noteService.getOne(id);
    }
    @PostMapping(path = "/note")
    public Note createNote(@RequestBody Note note){
        Classe classe=note.getExamenClasse().getClasse();
        Matiere matiere=note.getExamenClasse().getExamen().getMatiere();
        if(classe.getElevesClasses().stream().filter(ec->ec.getEleve().getId().equals(note.getEleve().getId())).count()<1)
            throw  new RuntimeException("Eleve n'appartient pas a la classe ");
        if(classe.getEnseignantMatiereClasses().stream()
                .filter(emc->emc.getEnseignant().getId().equals(note.getEnseignant().getId().equals(note.getEnseignant().getId()) &&
                         emc.getMatiere().getId().equals(matiere.getId()))).count()<1)
           throw  new RuntimeException("Enseignant n'a pas le droit de noter ce etudiant ou cette matiere ");

        return  _noteService.add(note);
    }

    @PutMapping(path = "/note")
    public Note UpdateNote(@RequestBody Note note){
        return  _noteService.update(note);
    }

    @DeleteMapping (path = "/note/{id}")
    public Note deteNote(@PathVariable Long id){
        return  _noteService.delete(id);
    }

    @RequestMapping(path = "/notesByUser/{id}")
    public List<Note> getALLNoteByEleveID(@PathVariable Long id){
        return  _noteService.getAll().stream().filter(n->n.getEleve().getId().equals(id)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/notesByExamen/{id}")
    public List<Note> getALLNoteByExamenID(@PathVariable Long id){
        return  _noteService.getAll().stream().filter(n->n.getExamenClasse().getExamen().getId().equals(id)).collect(Collectors.toList());
    }





}
