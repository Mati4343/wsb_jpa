package com.jpacourse.dto;
import java.io.Serializable;

public class ToMedicalTreatment implements Serializable {
    private Long id;
    private String description;
    private String typeTreatment;

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

    public String getTypeTreatment() {
        return typeTreatment;
    }
    public void setTypeTreatment(String typeTreatment) {
        this.typeTreatment = typeTreatment;
    }

    
}
