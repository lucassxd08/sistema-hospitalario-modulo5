package com.hospital.historia_clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.historia_clinica.model.HistoriaClinica;
import com.hospital.historia_clinica.service.AlergiaService;
import com.hospital.historia_clinica.service.AntecedenteFamiliarService;
import com.hospital.historia_clinica.service.AntecedenteService;
import com.hospital.historia_clinica.service.HistoriaClinicaService;
import com.hospital.historia_clinica.service.PacienteService;

@Controller
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;
    private final PacienteService pacienteService;
    private final AntecedenteService antecedenteService;
    private final AntecedenteFamiliarService antecedenteFamiliarService;
    private final AlergiaService alergiaService;

    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService,
                                      PacienteService pacienteService,
                                      AntecedenteService antecedenteService,
                                      AntecedenteFamiliarService antecedenteFamiliarService,
                                      AlergiaService alergiaService) {
        this.historiaClinicaService = historiaClinicaService;
        this.pacienteService = pacienteService;
        this.antecedenteService = antecedenteService;
        this.antecedenteFamiliarService = antecedenteFamiliarService;
        this.alergiaService = alergiaService;
    }

    // RF-HC-02: listar las historias clinicas para poder consultarlas
    @GetMapping("/historias")
    public String listarHistorias(Model model) {
        model.addAttribute("historias", historiaClinicaService.listarTodas());
        return "historias";
    }

    // RF-HC-01: elegir el paciente al que se le genera la historia
    @GetMapping("/historias/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "historia-form";
    }

    @PostMapping("/historias/guardar")
    public String guardarHistoria(@RequestParam Long pacienteId) {
        historiaClinicaService.crear(pacienteId);
        return "redirect:/historias";
    }

    // RF-HC-02 y RF-HC-03: consultar la historia y mostrar los datos basicos del paciente
    @GetMapping("/historias/{id}")
    public String verHistoria(@PathVariable Long id, Model model) {
        HistoriaClinica historia = historiaClinicaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Historia clinica no encontrada"));
        model.addAttribute("historia", historia);
        model.addAttribute("antecedentes", antecedenteService.listarPorHistoria(id));
        model.addAttribute("familiares", antecedenteFamiliarService.listarPorHistoria(id));
        model.addAttribute("alergias", alergiaService.listarPorHistoria(id));
        return "historia-detalle";
    }
}
