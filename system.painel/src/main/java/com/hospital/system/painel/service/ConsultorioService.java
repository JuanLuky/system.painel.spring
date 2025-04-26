package com.hospital.system.painel.service;

import com.hospital.system.painel.dto.ConsultorioDTO;
import com.hospital.system.painel.entity.Consultorio;
import com.hospital.system.painel.mapper.ConsultorioMapper;
import com.hospital.system.painel.repository.ConsultorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultorioService {

    private final ConsultorioRepository consultorioRepository;

    public ConsultorioService(ConsultorioRepository consultorioRepository) {
        this.consultorioRepository = consultorioRepository;
    }

    public ConsultorioDTO cadastrarConsultorio(ConsultorioDTO dto) {
        Consultorio consultorio = new Consultorio();
        consultorio.setId(dto.id());
        consultorio.setNome(dto.nome());
        consultorio.setAtivo(dto.ativo());

        Consultorio savedConsultorio = consultorioRepository.save(consultorio);
        return ConsultorioMapper.toDTO(savedConsultorio);

    }

    public List<ConsultorioDTO> listarConsultorios() {
        List<Consultorio> consultorios = consultorioRepository.findAll();
        return consultorios.stream()
                .map(ConsultorioMapper::toDTO)
                .collect(Collectors.toList());
    }

}
