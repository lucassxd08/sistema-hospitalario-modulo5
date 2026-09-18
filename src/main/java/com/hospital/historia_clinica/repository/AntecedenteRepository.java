package com.hospital.historia_clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.historia_clinica.model.Antecedente;

public interface AntecedenteRepository extends JpaRepository<Antecedente, Long> {

    List<Antecedente> findByHistoriaClinicaId(Long historiaClinicaId);
}
