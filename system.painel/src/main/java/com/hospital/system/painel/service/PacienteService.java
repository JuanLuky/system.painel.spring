package com.hospital.system.painel.service;


import com.hospital.system.painel.dto.PacienteDTO;
import com.hospital.system.painel.entity.Paciente;
import com.hospital.system.painel.mapper.PacienteMapper;
import com.hospital.system.painel.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteDTO cadastrarPaciente(PacienteDTO dto) {
        // Aqui você pode adicionar a lógica para cadastrar o paciente
        Paciente paciente = new Paciente();
        paciente.setId(dto.id());
        paciente.setNome(dto.nome());
        paciente.setPrioridade(dto.prioridade());
        paciente.setDataCadastro(dto.dataCadastro());

        // Salvar o paciente no banco de dados
        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        // Retornar o paciente salvo como DTO
        return PacienteMapper.toDTO(pacienteSalvo);
    }

    public List<PacienteDTO> listarPacientes() {

        List<Paciente> pacientes = pacienteRepository.findAll();
        // Mapear a lista de Paciente para PacienteDTO
        return pacientes.stream()
                .map(PacienteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
