package com.hospital.historia_clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "antecedente")
public class Antecedente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long historiaClinicaId;

    private String categoria;

    private String descripcion;

    private String fechaRegistro;

    private String observaciones;

    // Constructor vacio obligatorio para JPA
    public Antecedente() {
    }

    public Antecedente(Long historiaClinicaId, String categoria, String descripcion,
                       String fechaRegistro, String observaciones) {
        this.historiaClinicaId = historiaClinicaId;
        this.categoria = categoria;
        this.descripcion = descripcion;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
