package com.hospital.historia_clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.historia_clinica.model.Antecedente;

public interface AntecedenteRepository extends JpaRepository<Antecedente, Long> {
}
