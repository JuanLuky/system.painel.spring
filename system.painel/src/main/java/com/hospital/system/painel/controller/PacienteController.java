package com.hospital.system.painel.controller;

import com.hospital.system.painel.dto.PacienteDTO;
import com.hospital.system.painel.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> cadastrarPaciente(@RequestBody PacienteDTO dto) {
        return ResponseEntity.ok(pacienteService.cadastrarPaciente(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPacientes(@RequestParam Long id) {
        return ResponseEntity.ok(pacienteService.buscarPaciente(id));
    }
    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }
}
