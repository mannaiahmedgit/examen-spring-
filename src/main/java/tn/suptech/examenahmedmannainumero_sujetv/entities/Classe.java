package tn.suptech.examenahmedmannainumero_sujetv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private  Long id ;
    @Column(name ="DESCRIPTION")
    private  String DESCRIPTION;
    @ManyToOne
    private Semestre semestre;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "classe")
    @JsonIgnore
    private List<EleveClass> elevesClasses;
    @OneToMany(mappedBy = "classe")
    @JsonIgnore
    private List<EnseignantMatiereClass> enseignantMatiereClasses;
    @OneToMany(mappedBy = "classe")
    @JsonIgnore
    private List<ExamenClasse> examenClasses;
    public Classe() {
    }

    public Classe(Long id, String DESCRIPTION, Semestre semestre) {
        this.id = id;
        this.DESCRIPTION = DESCRIPTION;
        this.semestre = semestre;
    }

    public List<EleveClass> getElevesClasses() {
        return elevesClasses;
    }

    public void setElevesClasses(List<EleveClass> elevesClasses) {
        this.elevesClasses = elevesClasses;
    }

    public Long getId() {
        return id;
    }

    public List<EnseignantMatiereClass> getEnseignantMatiereClasses() {
        return enseignantMatiereClasses;
    }

    public void setEnseignantMatiereClasses(List<EnseignantMatiereClass> enseignantMatiereClasses) {
        this.enseignantMatiereClasses = enseignantMatiereClasses;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}
