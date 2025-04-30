package com.hospital.system.painel.repository;

import com.hospital.system.painel.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findFirstByOrderByPrioridadeDescDataCadastroAsc();



}
