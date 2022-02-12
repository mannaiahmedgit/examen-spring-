package tn.suptech.examenahmedmannainumero_sujetv.dto;


import tn.suptech.examenahmedmannainumero_sujetv.entities.Matiere;

import java.util.ArrayList;
import java.util.List;

public class DtoModule {

    private  Long id ;

    private  String libelleeModule;
    private  Double moyenneModule ;
    private List<DtoMatiere> dtoMatiereList=new ArrayList<DtoMatiere>();

    public DtoModule() {
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

    public List<DtoMatiere> getDtoMatiereList() {
        return dtoMatiereList;
    }

    public void setDtoMatiereList(List<DtoMatiere> dtoMatiereList) {
        this.dtoMatiereList = dtoMatiereList;
    }

    public Double getMoyenneModule() {
        return moyenneModule;
    }

    public void setMoyenneModule(Double moyenneModule) {
        this.moyenneModule = moyenneModule;
    }
}
