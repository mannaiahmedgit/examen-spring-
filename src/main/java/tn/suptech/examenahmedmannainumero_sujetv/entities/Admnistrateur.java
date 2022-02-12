package tn.suptech.examenahmedmannainumero_sujetv.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("A")
public class Admnistrateur extends  User implements Serializable {
    public Admnistrateur(String prenom, String nom, String login, String password, String email) {
        super(prenom, nom, login, password, email);
    }

    public Admnistrateur() {
    }

}
