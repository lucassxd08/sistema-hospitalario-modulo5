package com.hospital.historia_clinica.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "condicion_medica")
public class CondicionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @JsonIgnore
    @ManyToMany(mappedBy = "antecedentesFamiliares")
    private List<HistoriaClinica> historias = new ArrayList<>();

    public CondicionMedica() {
    }

    public CondicionMedica(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<HistoriaClinica> getHistorias() {
        return historias;
    }

    public void setHistorias(List<HistoriaClinica> historias) {
        this.historias = historias;
    }
}