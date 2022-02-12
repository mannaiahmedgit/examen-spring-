package tn.suptech.examenahmedmannainumero_sujetv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ExamenClasse  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private  Long id ;
    @ManyToOne
    private  Examen examen;
    @ManyToOne
    private  Classe classe ;
    @JsonIgnore
    @OneToMany(mappedBy = "examenClasse")
    private List<Note> notes;

    public ExamenClasse(Long id, Examen examen, Classe classe) {
        this.id = id;
        this.examen = examen;
        this.classe = classe;
    }

    public ExamenClasse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
