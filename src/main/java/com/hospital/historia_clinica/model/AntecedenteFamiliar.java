package com.hospital.historia_clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "antecedente_familiar")
public class AntecedenteFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long historiaClinicaId;

    private String enfermedad;

    private String parentesco;

    private String fechaRegistro;

    private String observaciones;

    // Constructor vacio obligatorio para JPA
    public AntecedenteFamiliar() {
    }

    public AntecedenteFamiliar(Long historiaClinicaId, String enfermedad, String parentesco,
                               String fechaRegistro, String observaciones) {
        this.historiaClinicaId = historiaClinicaId;
        this.enfermedad = enfermedad;
        this.parentesco = parentesco;
        this.fechaRegistro = fechaRegistro;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHistoriaClinicaId() {
        return historiaClinicaId;
    }

    public void setHistoriaClinicaId(Long historiaClinicaId) {
        this.historiaClinicaId = historiaClinicaId;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
