package tn.suptech.examenahmedmannainumero_sujetv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Matiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private  Long id ;
    @Column(name ="LIBELLEE")
    private  String libelleeMatiere;
    @Column(name ="Coefficient")
    private  double coeifficient;
    @ManyToOne
    private  Module module ;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "matiere")
    @JsonIgnore
    private List<Examen> examens ;
    @OneToMany(mappedBy = "matiere")
    @JsonIgnore
    private List<EnseignantMatiereClass> enseignantMatiereClasses;

    public Matiere() {
    }

    public Matiere(Long id, String libelleeMatiere, double coeifficient, Module module) {
        this.id = id;
        this.libelleeMatiere = libelleeMatiere;
        this.coeifficient = coeifficient;
        this.module = module;
    }

    public Long getId() {
        return id;
    }

    public List<Examen> getExamens() {
        return examens;
    }

    public void setExamens(List<Examen> examens) {
        this.examens = examens;
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

    public String getLibelleeMatiere() {
        return libelleeMatiere;
    }

    public void setLibelleeMatiere(String libelleeMatiere) {
        this.libelleeMatiere = libelleeMatiere;
    }

    public double getCoeifficient() {
        return coeifficient;
    }

    public void setCoeifficient(double coeifficient) {
        this.coeifficient = coeifficient;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
