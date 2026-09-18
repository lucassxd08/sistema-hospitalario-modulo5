package com.hospital.historia_clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.historia_clinica.model.Alergia;

public interface AlergiaRepository extends JpaRepository<Alergia, Long> {

    List<Alergia> findByHistoriaClinicaId(Long historiaClinicaId);
}
