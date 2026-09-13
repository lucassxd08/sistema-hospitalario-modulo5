package com.hospital.historia_clinica.service;

import com.hospital.historia_clinica.model.HistoriaClinica;
import com.hospital.historia_clinica.model.Paciente;
import com.hospital.historia_clinica.repository.HistoriaClinicaRepository;
import com.hospital.historia_clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;
    private final PacienteRepository pacienteRepository;

    @Autowired
    public HistoriaClinicaService(HistoriaClinicaRepository historiaClinicaRepository,
                                  PacienteRepository pacienteRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    // RF-HC-01: Generar historia clínica única para un paciente
    public HistoriaClinica crear(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + pacienteId));

        // Genera un número único simple basado en el id del paciente y la fecha
        String numeroHistoria = "HC-" + String.format("%06d", pacienteId) + "-" + System.currentTimeMillis() % 10000;

        HistoriaClinica historia = new HistoriaClinica(
                numeroHistoria,
                paciente,
                LocalDate.now(),
                "ACTIVA"
        );

        return historiaClinicaRepository.save(historia);
    }

    // RF-HC-02: Consultar la historia clínica por su propio id
    public Optional<HistoriaClinica> buscarPorId(Long id) {
        return historiaClinicaRepository.findById(id);
    }

    // RF-HC-03: Mostrar historia clínica (con datos del paciente) a partir del id del paciente
    public Optional<HistoriaClinica> buscarPorPacienteId(Long pacienteId) {
        return historiaClinicaRepository.findByPacienteId(pacienteId);
    }

    public List<HistoriaClinica> listarTodas() {
        return historiaClinicaRepository.findAll();
    }

    // Para completar el CRUD (aunque no lo pida explícitamente el RF)
    public HistoriaClinica actualizar(Long id, String estado) {
        HistoriaClinica historia = historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historia clínica no encontrada con id: " + id));
        historia.setEstado(estado);
        return historiaClinicaRepository.save(historia);
    }

    public void eliminar(Long id) {
        historiaClinicaRepository.deleteById(id);
    }
}