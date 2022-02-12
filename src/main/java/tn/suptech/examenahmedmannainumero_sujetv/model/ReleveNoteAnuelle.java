package tn.suptech.examenahmedmannainumero_sujetv.model;

import tn.suptech.examenahmedmannainumero_sujetv.dto.DtoClasse;
import tn.suptech.examenahmedmannainumero_sujetv.dto.DtoEleve;
import tn.suptech.examenahmedmannainumero_sujetv.dto.DtoNiveau;
import tn.suptech.examenahmedmannainumero_sujetv.dto.DtoSemestre;

import java.util.ArrayList;
import java.util.List;

public class ReleveNoteAnuelle {
    private DtoEleve eleve= new DtoEleve();
    private DtoNiveau niveau =new DtoNiveau();
    private String Resultat="aa";
    private Double moyenneAnuelle;

    private  List<ReleveNote> releveNoteList= new ArrayList<ReleveNote>();

    public ReleveNoteAnuelle() {
    }

    public DtoEleve getEleve() {
        return eleve;
    }

    public void setEleve(DtoEleve eleve) {
        this.eleve = eleve;
    }



    public DtoNiveau getNiveau() {
        return niveau;
    }

    public void setNiveau(DtoNiveau niveau) {
        this.niveau = niveau;
    }

    public List<ReleveNote> getReleveNoteList() {
        return releveNoteList;
    }

    public void setReleveNoteList(List<ReleveNote> releveNoteList) {
        this.releveNoteList = releveNoteList;
    }

    public Double getMoyenneAnuelle() {
        return moyenneAnuelle;
    }

    public void setMoyenneAnuelle(Double moyenneAnuelle) {
        this.moyenneAnuelle = moyenneAnuelle;
    }

    public String getResultat() {
        return Resultat;
    }

    public void setResultat(String resultat) {
        Resultat = resultat;
    }
}
