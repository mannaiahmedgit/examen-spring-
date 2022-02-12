package tn.suptech.examenahmedmannainumero_sujetv.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Long id ;
    private double noteExamen;
    @ManyToOne
    private  ExamenClasse examenClasse;
    @ManyToOne
    private  Enseignant enseignant;

    @ManyToOne
    private  Eleve eleve;

    public Note() {
    }


    public Note(Long id, double noteExamen, ExamenClasse examenClasse, Enseignant enseignant, Eleve eleve) {
        this.id = id;
        this.noteExamen = noteExamen;
        this.examenClasse = examenClasse;
        this.enseignant = enseignant;
        this.eleve = eleve;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNoteExamen() {
        return noteExamen;
    }

    public void setNoteExamen(double noteExamen) {
        this.noteExamen = noteExamen;
    }

    public ExamenClasse getExamenClasse() {
        return examenClasse;
    }

    public void setExamenClasse(ExamenClasse examenClasse) {
        this.examenClasse = examenClasse;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
}
