package com.hospital.historia_clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.historia_clinica.model.Antecedente;
import com.hospital.historia_clinica.repository.AntecedenteRepository;

@Service
public class AntecedenteService {

    @Autowired
    private AntecedenteRepository repo;

    public List<Antecedente> listar() {
        return repo.findAll();
    }

    public Antecedente guardar(Antecedente a) {
        return repo.save(a);
    }

    public Antecedente obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
