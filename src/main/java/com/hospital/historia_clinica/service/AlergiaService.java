package com.hospital.historia_clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.historia_clinica.model.Alergia;
import com.hospital.historia_clinica.model.HistoriaClinica;
import com.hospital.historia_clinica.repository.AlergiaRepository;
import com.hospital.historia_clinica.repository.HistoriaClinicaRepository;

@Service
public class AlergiaService {

    @Autowired
    private AlergiaRepository repo;

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public List<Alergia> listar() {
        return repo.findAll();
    }

    public List<Alergia> listarPorHistoria(Long historiaClinicaId) {
        return repo.findByHistoriaClinicaId(historiaClinicaId);
    }

    // No se guarda una alergia sin una historia clinica que ya exista
    public Alergia guardar(Alergia a) {
        if (a.getHistoriaClinica() == null || a.getHistoriaClinica().getId() == null) {
            throw new RuntimeException("La alergia debe estar asociada a una historia clinica");
        }
        HistoriaClinica historia = historiaClinicaRepository.findById(a.getHistoriaClinica().getId())
                .orElseThrow(() -> new RuntimeException("Historia clinica no existe"));
        a.setHistoriaClinica(historia);
        return repo.save(a);
    }

    public Alergia obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
