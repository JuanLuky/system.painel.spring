package com.hospital.system.painel.repository;

import com.hospital.system.painel.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
    // Consultórios ativos
    List<Consultorio> findByAtivoTrue();
}
