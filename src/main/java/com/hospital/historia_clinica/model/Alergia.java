package com.hospital.historia_clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alergia")
public class Alergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long historiaClinicaId;

    private String alergia;

    private String tipo;

    private String reaccion;

    private String fechaRegistro;

    private String observaciones;

    // Constructor vacio obligatorio para JPA
    public Alergia() {
    }

    public Alergia(Long historiaClinicaId, String alergia, String tipo, String reaccion,
                   String fechaRegistro, String observaciones) {
        this.historiaClinicaId = historiaClinicaId;
        this.alergia = alergia;
        this.tipo = tipo;
        this.reaccion = reaccion;
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

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReaccion() {
        return reaccion;
    }

    public void setReaccion(String reaccion) {
        this.reaccion = reaccion;
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
