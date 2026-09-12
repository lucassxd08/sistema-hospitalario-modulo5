package com.hospital.historia_clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.historia_clinica.model.Alergia;

public interface AlergiaRepository extends JpaRepository<Alergia, Long> {
}
