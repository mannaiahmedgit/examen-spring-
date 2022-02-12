package tn.suptech.examenahmedmannainumero_sujetv.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class DtoMatiere {
    private  Long id ;

    private  String libelleeMatiere;

    private  Double coeifficient;
    private  Double moyenneMatiere ;
    @JsonIgnore
    private List<DtoExamen> dtoExamenList = new ArrayList<DtoExamen>();

    private  DtoEnseignant dtoEnseignant;
    public DtoMatiere() {
    }

    public Long getId() {
        return id;
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

    public Double getCoeifficient() {
        return coeifficient;
    }

    public void setCoeifficient(Double coeifficient) {
        this.coeifficient = coeifficient;
    }

    public List<DtoExamen> getDtoExamenList() {
        return dtoExamenList;
    }

    public void setDtoExamenList(List<DtoExamen> dtoExamenList) {
        this.dtoExamenList = dtoExamenList;
    }

    public DtoEnseignant getDtoEnseignant() {
        return dtoEnseignant;
    }

    public void setDtoEnseignant(DtoEnseignant dtoEnseignant) {
        this.dtoEnseignant = dtoEnseignant;
    }

    public Double getMoyenneMatiere() {
        return moyenneMatiere;
    }

    public void setMoyenneMatiere(Double moyenneMatiere) {
        this.moyenneMatiere = moyenneMatiere;
    }
}
