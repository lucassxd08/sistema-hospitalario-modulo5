package com.hospital.historia_clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.historia_clinica.model.Antecedente;
import com.hospital.historia_clinica.model.HistoriaClinica;
import com.hospital.historia_clinica.repository.AntecedenteRepository;
import com.hospital.historia_clinica.repository.HistoriaClinicaRepository;

@Service
public class AntecedenteService {

    @Autowired
    private AntecedenteRepository repo;

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public List<Antecedente> listar() {
        return repo.findAll();
    }

    public List<Antecedente> listarPorHistoria(Long historiaClinicaId) {
        return repo.findByHistoriaClinicaId(historiaClinicaId);
    }

    // No se guarda un antecedente sin una historia clinica que ya exista
    public Antecedente guardar(Antecedente a) {
        if (a.getHistoriaClinica() == null || a.getHistoriaClinica().getId() == null) {
            throw new RuntimeException("El antecedente debe estar asociado a una historia clinica");
        }
        HistoriaClinica historia = historiaClinicaRepository.findById(a.getHistoriaClinica().getId())
                .orElseThrow(() -> new RuntimeException("Historia clinica no existe"));
        a.setHistoriaClinica(historia);
        return repo.save(a);
    }

    public Antecedente obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
