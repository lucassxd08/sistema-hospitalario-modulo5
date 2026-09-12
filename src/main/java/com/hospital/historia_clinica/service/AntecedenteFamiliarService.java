package com.hospital.historia_clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.historia_clinica.model.AntecedenteFamiliar;
import com.hospital.historia_clinica.repository.AntecedenteFamiliarRepository;

@Service
public class AntecedenteFamiliarService {

    @Autowired
    private AntecedenteFamiliarRepository repo;

    public List<AntecedenteFamiliar> listar() {
        return repo.findAll();
    }

    public AntecedenteFamiliar guardar(AntecedenteFamiliar a) {
        return repo.save(a);
    }

    public AntecedenteFamiliar obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
