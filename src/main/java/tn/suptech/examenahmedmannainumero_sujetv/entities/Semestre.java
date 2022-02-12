package tn.suptech.examenahmedmannainumero_sujetv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Semestre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private  Long id ;
    @Column(name ="LIBELLEE")
    private  String libelleeSemestre;
    @ManyToOne
    private  Niveau niveau ;

    @OneToMany(mappedBy = "semestre" , fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Module> modules ;
    @OneToMany(mappedBy = "semestre")
    @JsonIgnore
    private  List<Classe> classes ;

    public Semestre() {
    }

    public Semestre(Long id, String libelleeSemestre, Niveau niveau) {
        this.id = id;
        this.libelleeSemestre = libelleeSemestre;
        this.niveau = niveau;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelleeSemestre() {
        return libelleeSemestre;
    }

    public void setLibelleeSemestre(String libelleeSemestre) {
        this.libelleeSemestre = libelleeSemestre;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
