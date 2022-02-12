package tn.suptech.examenahmedmannainumero_sujetv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("EL")
@JsonIgnoreProperties({"eleveClasses","notes"})
public class Eleve  extends  User implements Serializable {
    private Long numeroInscription;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "eleve" )
    @JsonIgnore
    private List<EleveClass> eleveClasses;
    @OneToMany(mappedBy = "eleve")
    @JsonIgnore
    private List<Note> notes;


    public Eleve() {

    }
    public Eleve(String prenom, String nom, String login, String password, String email, Long numeroInscription) {
        super(prenom, nom, login, password, email);
        this.numeroInscription = numeroInscription;
    }

    public Eleve(Long numeroInscription) {
        this.numeroInscription = numeroInscription;
    }



    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<EleveClass> getEleveClasses() {
        return eleveClasses;
    }

    public void setEleveClasses(List<EleveClass> eleveClasses) {
        this.eleveClasses = eleveClasses;
    }

    public Long getNumeroInscription() {
        return numeroInscription;
    }

    public void setNumeroInscription(Long numeroInscription) {
        this.numeroInscription = numeroInscription;
    }
}
