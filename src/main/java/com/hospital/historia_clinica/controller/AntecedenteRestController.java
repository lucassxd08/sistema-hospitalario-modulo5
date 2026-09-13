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

import com.hospital.historia_clinica.model.Antecedente;
import com.hospital.historia_clinica.service.AntecedenteService;

@RestController
@RequestMapping("/api/antecedentes")
public class AntecedenteRestController {

    @Autowired
    private AntecedenteService service;

    @GetMapping
    public List<Antecedente> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Antecedente> crear(@RequestBody Antecedente a) {
        Antecedente creado = service.guardar(a);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Antecedente> obtener(@PathVariable Long id) {
        Antecedente a = service.obtener(id);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(a);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Antecedente> actualizar(@PathVariable Long id, @RequestBody Antecedente datos) {
        Antecedente a = service.obtener(id);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        a.setHistoriaClinica(datos.getHistoriaClinica());
        a.setCategoria(datos.getCategoria());
        a.setDescripcion(datos.getDescripcion());
        a.setFechaRegistro(datos.getFechaRegistro());
        a.setObservaciones(datos.getObservaciones());
        return ResponseEntity.ok(service.guardar(a));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Antecedente a = service.obtener(id);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
