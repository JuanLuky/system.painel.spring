package com.hospital.system.painel.repository;

import com.hospital.system.painel.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
