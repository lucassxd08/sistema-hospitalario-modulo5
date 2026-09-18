package com.hospital.historia_clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.historia_clinica.model.AntecedenteFamiliar;
import com.hospital.historia_clinica.service.AntecedenteFamiliarService;

@RestController
@RequestMapping("/api/antecedentes-familiares")
public class AntecedenteFamiliarRestController {

    @Autowired
    private AntecedenteFamiliarService service;

    @GetMapping
    public List<AntecedenteFamiliar> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<AntecedenteFamiliar> crear(@RequestBody AntecedenteFamiliar a) {
        AntecedenteFamiliar creado = service.guardar(a);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AntecedenteFamiliar> obtener(@PathVariable Long id) {
        AntecedenteFamiliar a = service.obtener(id);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(a);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AntecedenteFamiliar> actualizar(@PathVariable Long id,
                                                          @RequestBody AntecedenteFamiliar datos) {
        AntecedenteFamiliar a = service.obtener(id);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        a.setHistoriaClinica(datos.getHistoriaClinica());
        a.setEnfermedad(datos.getEnfermedad());
        a.setParentesco(datos.getParentesco());
        a.setFechaRegistro(datos.getFechaRegistro());
        a.setObservaciones(datos.getObservaciones());
        return ResponseEntity.ok(service.guardar(a));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        AntecedenteFamiliar a = service.obtener(id);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
