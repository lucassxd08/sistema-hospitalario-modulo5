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

import com.hospital.historia_clinica.model.Alergia;
import com.hospital.historia_clinica.service.AlergiaService;

@RestController
@RequestMapping("/api/alergias")
public class AlergiaRestController {

    @Autowired
    private AlergiaService service;

    @GetMapping
    public List<Alergia> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Alergia> crear(@RequestBody Alergia a) {
        Alergia creada = service.guardar(a);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alergia> obtener(@PathVariable Long id) {
        Alergia a = service.obtener(id);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(a);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alergia> actualizar(@PathVariable Long id, @RequestBody Alergia datos) {
        Alergia a = service.obtener(id);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        a.setHistoriaClinicaId(datos.getHistoriaClinicaId());
        a.setNombre(datos.getNombre());
        a.setTipo(datos.getTipo());
        a.setReaccion(datos.getReaccion());
        a.setFechaRegistro(datos.getFechaRegistro());
        a.setObservaciones(datos.getObservaciones());
        return ResponseEntity.ok(service.guardar(a));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Alergia a = service.obtener(id);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
