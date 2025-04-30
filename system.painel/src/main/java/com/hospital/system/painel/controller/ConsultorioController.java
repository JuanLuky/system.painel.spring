package com.hospital.system.painel.controller;

import com.hospital.system.painel.dto.ConsultorioDTO;
import com.hospital.system.painel.entity.Consultorio;
import com.hospital.system.painel.enums.StatusConsultorio;
import com.hospital.system.painel.mapper.ConsultorioMapper;
import com.hospital.system.painel.service.ConsultorioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/consultorios")
public class ConsultorioController {

    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }


    @PostMapping
    public ResponseEntity<ConsultorioDTO> cadastrarConsultorio(@RequestBody ConsultorioDTO dto) {
        return ResponseEntity.ok(consultorioService.cadastrarConsultorio(dto));
    }

    @GetMapping
    public ResponseEntity<List<ConsultorioDTO>> listar() {
        return ResponseEntity.ok(consultorioService.listarConsultorios());
    }

    @PatchMapping("/consultorios/{id}")
    public ResponseEntity<ConsultorioDTO> atualizarStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        String novoStatus  = body.get("status");
        Consultorio consultorio = consultorioService.atualizarStatus(id, StatusConsultorio.valueOf(novoStatus));
        return ResponseEntity.ok(ConsultorioMapper.toDTO(consultorio));
    }

}
