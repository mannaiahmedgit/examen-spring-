package tn.suptech.examenahmedmannainumero_sujetv.dto;

import javax.persistence.Column;
import java.util.Date;

public class DtoExamen {
    private  Long id ;

    private  String description;

    private Date date;
    private double Note;
    public DtoExamen() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getNote() {
        return Note;
    }

    public void setNote(double note) {
        Note = note;
    }
}
