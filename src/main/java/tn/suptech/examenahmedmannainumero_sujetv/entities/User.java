package tn.suptech.examenahmedmannainumero_sujetv.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity( name = "T_USER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "UserType")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id ;
    @Column(name = "PRENOM")
    private  String prenom ;
    @Column(name = "NOM")
    private  String nom ;
    @Column(name = "LOGIN")
    private  String login ;
    @Column(name = "PASSWORD")
    private  String password ;
    @Column(name = "EMAIL")
    private  String Email ;

    public User( String prenom, String nom, String login, String password, String email) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.password = password;
        Email = email;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }



    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
