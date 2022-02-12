package tn.suptech.examenahmedmannainumero_sujetv.entities;

import com.fasterxml.jackson.annotation.*;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("EN")
public class Enseignant extends User implements Serializable {
    private Long numeroCarteIdentitee ;
    @OneToMany(mappedBy = "enseignant")
    @JsonIgnore
    private List<EnseignantMatiereClass> enseignantMatiereClasses;
    @OneToMany(mappedBy = "enseignant")
    @JsonIgnore
    private List<Note> notes;



    public Enseignant() {

    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<EnseignantMatiereClass> getEnseignantMatiereClasses() {
        return enseignantMatiereClasses;
    }

    public void setEnseignantMatiereClasses(List<EnseignantMatiereClass> enseignantMatiereClasses) {
        this.enseignantMatiereClasses = enseignantMatiereClasses;
    }

    public Enseignant(String prenom, String nom, String login, String password, String email, Long numeroCarteIdentitee) {
        super(prenom, nom, login, password, email);
        this.numeroCarteIdentitee = numeroCarteIdentitee;
    }

    public Enseignant(Long numeroCarteIdentitee) {
        this.numeroCarteIdentitee = numeroCarteIdentitee;
    }



    public Long getNumeroCarteIdentitee() {
        return numeroCarteIdentitee;
    }

    public void setNumeroCarteIdentitee(Long numeroCarteIdentitee) {
        this.numeroCarteIdentitee = numeroCarteIdentitee;
    }
}
