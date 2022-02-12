package tn.suptech.examenahmedmannainumero_sujetv.dto;


import java.util.List;

public class DtoSemestre {
    private  Long id ;

    private  String libelleeSemestre;
    private List<DtoModule> dtoModuleList;
    public DtoSemestre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelleeSemestre() {
        return libelleeSemestre;
    }

    public void setLibelleeSemestre(String libelleeSemestre) {
        this.libelleeSemestre = libelleeSemestre;
    }

    public List<DtoModule> getDtoModuleList() {
        return dtoModuleList;
    }

    public void setDtoModuleList(List<DtoModule> dtoModuleList) {
        this.dtoModuleList = dtoModuleList;
    }
}
