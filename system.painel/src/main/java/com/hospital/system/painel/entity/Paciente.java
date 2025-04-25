package com.hospital.system.painel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String nome;

    private LocalDateTime dataCadastro;

    private boolean chamado; // indica se já foi chamado

    private String consultorio; // ex: "Consultório 01"

    public Paciente() {
        this.dataCadastro = LocalDateTime.now();
        this.chamado = false;
    }
}
