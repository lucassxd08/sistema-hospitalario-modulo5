package com.hospital.historia_clinica.repository;

import com.hospital.historia_clinica.model.CondicionMedica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondicionMedicaRepository extends JpaRepository<CondicionMedica, Long> {
}