package com.hospital.historia_clinica.controller;

import com.hospital.historia_clinica.model.CondicionMedica;
import com.hospital.historia_clinica.repository.CondicionMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condiciones")
public class CondicionMedicaController {

    private final CondicionMedicaRepository condicionMedicaRepository;

    @Autowired
    public CondicionMedicaController(CondicionMedicaRepository condicionMedicaRepository) {
        this.condicionMedicaRepository = condicionMedicaRepository;
    }

    @PostMapping
    public ResponseEntity<CondicionMedica> crear(@RequestBody CondicionMedica condicion) {
        return new ResponseEntity<>(condicionMedicaRepository.save(condicion), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CondicionMedica>> listarTodas() {
        return ResponseEntity.ok(condicionMedicaRepository.findAll());
    }
}