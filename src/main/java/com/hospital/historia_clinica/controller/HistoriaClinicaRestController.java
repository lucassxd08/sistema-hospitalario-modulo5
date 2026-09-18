package com.hospital.historia_clinica.controller;

import com.hospital.historia_clinica.model.HistoriaClinica;
import com.hospital.historia_clinica.service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/historias")
public class HistoriaClinicaRestController {

    private final HistoriaClinicaService historiaClinicaService;

    @Autowired
    public HistoriaClinicaRestController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    // RF-HC-01: Generar número único de historia clínica para un paciente
    @PostMapping
    public ResponseEntity<HistoriaClinica> crear(@RequestBody Map<String, Long> body) {
        Long pacienteId = body.get("pacienteId");
        HistoriaClinica creada = historiaClinicaService.crear(pacienteId);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    // RF-HC-02: Consultar la historia clínica de un paciente (por id de la propia historia)
    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> buscarPorId(@PathVariable Long id) {
        return historiaClinicaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // RF-HC-03: Mostrar datos básicos del paciente asociados a su historia clínica
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<HistoriaClinica> buscarPorPacienteId(@PathVariable Long pacienteId) {
        return historiaClinicaService.buscarPorPacienteId(pacienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> listarTodas() {
        return ResponseEntity.ok(historiaClinicaService.listarTodas());
    }

    // Completar el CRUD (actualizar estado)
    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> actualizar(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String estado = body.get("estado");
        HistoriaClinica actualizada = historiaClinicaService.actualizar(id, estado);
        return ResponseEntity.ok(actualizada);
    }

    // Completar el CRUD (eliminar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historiaClinicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/condiciones/{condicionId}")
    public ResponseEntity<HistoriaClinica> agregarCondicion(@PathVariable Long id, @PathVariable Long condicionId) {
        return ResponseEntity.ok(historiaClinicaService.agregarCondicionFamiliar(id, condicionId));
    }

    @GetMapping("/{id}/condiciones")
    public ResponseEntity<java.util.List<com.hospital.historia_clinica.model.CondicionMedica>> listarCondiciones(@PathVariable Long id) {
        return ResponseEntity.ok(historiaClinicaService.listarCondicionesFamiliares(id));
    }

}