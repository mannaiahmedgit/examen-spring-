package tn.suptech.examenahmedmannainumero_sujetv.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EleveClass  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Long id ;
    @ManyToOne
    private  Classe classe;
    @ManyToOne
    private  Eleve eleve;

    public EleveClass() {
    }

    public EleveClass(Long id, Classe classe, Eleve eleve) {
        this.id = id;
        this.classe = classe;
        this.eleve = eleve;
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

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
}
