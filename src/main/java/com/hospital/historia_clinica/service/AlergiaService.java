package com.hospital.historia_clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.historia_clinica.model.Alergia;
import com.hospital.historia_clinica.repository.AlergiaRepository;

@Service
public class AlergiaService {

    @Autowired
    private AlergiaRepository repo;

    public List<Alergia> listar() {
        return repo.findAll();
    }

    public Alergia guardar(Alergia a) {
        return repo.save(a);
    }

    public Alergia obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
