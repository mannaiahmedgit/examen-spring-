package tn.suptech.examenahmedmannainumero_sujetv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private  Long id ;
    @Column(name ="LIBELLEE")
    private  String libelleeModule;
    @ManyToOne
    private  Semestre semestre ;
    @OneToMany(mappedBy = "module" ,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Matiere> matiers ;

    public Module(Long id, String libelleeModule, Semestre semestre) {
        this.id = id;
        this.libelleeModule = libelleeModule;
        this.semestre = semestre;

    }

    public Module() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelleeModule() {
        return libelleeModule;
    }

    public void setLibelleeModule(String libelleeModule) {
        this.libelleeModule = libelleeModule;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public List<Matiere> getMatiers() {
        return matiers;
    }

    public void setMatiers(List<Matiere> matiers) {
        this.matiers = matiers;
    }
}
