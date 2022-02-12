package tn.suptech.examenahmedmannainumero_sujetv.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EnseignantMatiereClass  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Long id ;
    @ManyToOne
    private  Classe classe;
    @ManyToOne
    private  Enseignant enseignant;

    @ManyToOne
    private  Matiere matiere;

    public EnseignantMatiereClass() {
    }

    public EnseignantMatiereClass(Long id, Classe classe, Enseignant enseignant, Matiere matiere) {
        this.id = id;
        this.classe = classe;
        this.enseignant = enseignant;
        this.matiere = matiere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
}
