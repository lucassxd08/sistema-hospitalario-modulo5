package com.hospital.historia_clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.historia_clinica.model.AntecedenteFamiliar;

public interface AntecedenteFamiliarRepository extends JpaRepository<AntecedenteFamiliar, Long> {

    List<AntecedenteFamiliar> findByHistoriaClinicaId(Long historiaClinicaId);
}
