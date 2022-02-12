package tn.suptech.examenahmedmannainumero_sujetv.dto;



public class DtoNiveau {
    private  Long id ;

    private  String libelleeNiveau;

    public DtoNiveau() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelleeNiveau() {
        return libelleeNiveau;
    }

    public void setLibelleeNiveau(String libelleeNiveau) {
        this.libelleeNiveau = libelleeNiveau;
    }
}
