package com.hospital.historia_clinica.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_historia", nullable = false, unique = true, length = 20)
    private String numeroHistoria;

    @OneToOne
    @JoinColumn(name = "paciente_id", nullable = false, unique = true)
    private Paciente paciente;

    @Column(name = "fecha_apertura", nullable = false)
    private LocalDate fechaApertura;

    @Column(nullable = false, length = 20)
    private String estado; // ACTIVA / INACTIVA

    @ManyToMany
    @JoinTable(
            name = "historia_condicion",
            joinColumns = @JoinColumn(name = "historia_clinica_id"),
            inverseJoinColumns = @JoinColumn(name = "condicion_id")
    )
    private List<CondicionMedica> antecedentesFamiliares = new ArrayList<>();

    // Constructores
    public HistoriaClinica() {
    }

    public HistoriaClinica(String numeroHistoria, Paciente paciente, LocalDate fechaApertura, String estado) {
        this.numeroHistoria = numeroHistoria;
        this.paciente = paciente;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(String numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<CondicionMedica> getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(List<CondicionMedica> antecedentesFamiliares) {
        this.antecedentesFamiliares = antecedentesFamiliares;
    }

    public void agregarCondicion(CondicionMedica condicion) {
        this.antecedentesFamiliares.add(condicion);
    }
}