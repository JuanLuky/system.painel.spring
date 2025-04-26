package com.hospital.system.painel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Long id;

    private String nome;

    private boolean prioridade; // indica se o paciente tem prioridade

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;


    public Paciente() {
        this.dataCadastro = LocalDateTime.now();
        this.prioridade = false;
    }
}
