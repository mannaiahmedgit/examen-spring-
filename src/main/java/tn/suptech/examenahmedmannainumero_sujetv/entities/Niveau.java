package tn.suptech.examenahmedmannainumero_sujetv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Niveau implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private  Long id ;
    @Column(name ="LIBELLEE")
    private  String LibelleeNiveau ;
    @OneToMany(mappedBy = "niveau",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Semestre> semestres ;

    public Niveau() {
    }

    public Niveau(Long id, String libelleeNiveau, List<Semestre> semestres) {
        this.id = id;
        LibelleeNiveau = libelleeNiveau;
        this.semestres = semestres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelleeNiveau() {
        return LibelleeNiveau;
    }

    public void setLibelleeNiveau(String libelleeNiveau) {
        LibelleeNiveau = libelleeNiveau;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }
}
