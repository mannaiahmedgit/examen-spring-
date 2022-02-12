package tn.suptech.examenahmedmannainumero_sujetv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.suptech.examenahmedmannainumero_sujetv.dto.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Module;


public class ReleveNote {
    @JsonIgnore
    private DtoEleve eleve= new DtoEleve();
    private DtoClasse classe =new DtoClasse() ;
    @JsonIgnore
    private DtoNiveau niveau =new DtoNiveau();
    private Double MoyenneSemestre ;
    private DtoSemestre semestre = new DtoSemestre();

    public ReleveNote() {
    }

    public DtoEleve getEleve() {
        return eleve;
    }

    public void setEleve(DtoEleve eleve) {
        this.eleve = eleve;
    }

    public DtoClasse getClasse() {
        return classe;
    }

    public void setClasse(DtoClasse classe) {
        this.classe = classe;
    }

    public DtoNiveau getNiveau() {
        return niveau;
    }

    public void setNiveau(DtoNiveau niveau) {
        this.niveau = niveau;
    }

    public DtoSemestre getSemestre() {
        return semestre;
    }

    public void setSemestre(DtoSemestre semestre) {
        this.semestre = semestre;
    }

    public Double getMoyenneSemestre() {
        return MoyenneSemestre;
    }

    public void setMoyenneSemestre(Double moyenneSemestre) {
        MoyenneSemestre = moyenneSemestre;
    }
}
