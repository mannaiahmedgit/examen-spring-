package tn.suptech.examenahmedmannainumero_sujetv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Examen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private  Long id ;
    @Column(name ="DESCRIPTION")
    private  String description;
    @Column(name ="DATE")
    private Date date;
    @ManyToOne
    private  Matiere matiere ;

    @OneToMany(mappedBy = "examen")
    @JsonIgnore
    private List<ExamenClasse> examenClasses;
    public Examen() {
    }

    public Examen(Long id, String description, Date date, Matiere matiere) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.matiere = matiere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
}
