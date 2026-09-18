package com.hospital.historia_clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.historia_clinica.model.AntecedenteFamiliar;
import com.hospital.historia_clinica.model.HistoriaClinica;
import com.hospital.historia_clinica.repository.AntecedenteFamiliarRepository;
import com.hospital.historia_clinica.repository.HistoriaClinicaRepository;

@Service
public class AntecedenteFamiliarService {

    @Autowired
    private AntecedenteFamiliarRepository repo;

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public List<AntecedenteFamiliar> listar() {
        return repo.findAll();
    }

    public List<AntecedenteFamiliar> listarPorHistoria(Long historiaClinicaId) {
        return repo.findByHistoriaClinicaId(historiaClinicaId);
    }

    // No se guarda un antecedente familiar sin una historia clinica que ya exista
    public AntecedenteFamiliar guardar(AntecedenteFamiliar a) {
        if (a.getHistoriaClinica() == null || a.getHistoriaClinica().getId() == null) {
            throw new RuntimeException("El antecedente familiar debe estar asociado a una historia clinica");
        }
        HistoriaClinica historia = historiaClinicaRepository.findById(a.getHistoriaClinica().getId())
                .orElseThrow(() -> new RuntimeException("Historia clinica no existe"));
        a.setHistoriaClinica(historia);
        return repo.save(a);
    }

    public AntecedenteFamiliar obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
