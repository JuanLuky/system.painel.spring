package com.hospital.system.painel.service;

import com.hospital.system.painel.dto.SenhaDTO;
import com.hospital.system.painel.entity.Consultorio;
import com.hospital.system.painel.entity.Paciente;
import com.hospital.system.painel.entity.Senha;
import com.hospital.system.painel.mapper.SenhaMapper;
import com.hospital.system.painel.repository.ConsultorioRepository;
import com.hospital.system.painel.repository.PacienteRepository;
import com.hospital.system.painel.repository.SenhaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SenhaService {

    private final SenhaRepository senhaRepository;
    private final PacienteRepository pacienteRepository;
    private final ConsultorioRepository consultorioRepository;

    public SenhaService(SenhaRepository senhaRepository, PacienteRepository pacienteRepository, ConsultorioRepository consultorioRepository) {
        this.senhaRepository = senhaRepository;
        this.pacienteRepository = pacienteRepository;
        this.consultorioRepository = consultorioRepository;
    }

    public SenhaDTO chamarPaciente(Long pacienteid)  {

        Optional<Paciente> pacienteOpt = pacienteRepository.findById(pacienteid);

        if(pacienteOpt.isEmpty()) {
            throw new RuntimeException("Paciente não encontrado");
        }

        // buscar um consultório ativo e disponível
        List<Consultorio> consultorios = consultorioRepository.findAll();
        Optional<Consultorio> consultorioDisponivel = consultorios.stream()
                .filter(Consultorio::isAtivo)
                .findFirst();

        if(consultorioDisponivel.isEmpty()) {
            throw new RuntimeException("Nenhum consultório disponível");
        }

        // Criar uma senha
        Senha senha = new Senha();
        senha.setId(senha.getId());
        senha.setPaciente(pacienteOpt.get());
        senha.setConsultorio(consultorioDisponivel.get());
        senha.setChamado(true);
        senha.setDataHora(LocalDateTime.now());

        // Salvar a senha no banco de dados
        Senha senhaSalva = senhaRepository.save(senha);
        // Retornar a senha salva como DTO
        return SenhaMapper.toDTO(senhaSalva);
    }

    public List<SenhaDTO> listarSenhasChamadas() {
        List<Senha> senhasChamadas = senhaRepository.findByChamadoTrue();
        return senhasChamadas.stream()
                .filter(Senha::isChamado)
                .map(SenhaMapper::toDTO)
                .toList();
    }
}
