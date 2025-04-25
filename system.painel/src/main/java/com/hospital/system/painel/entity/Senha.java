package com.hospital.system.painel.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_senha")
public class Senha {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Consultorio consultorio;

    private boolean chamado;

    private LocalDateTime dataHora;

    public Senha() {
        this.chamado = false;
        this.dataHora = LocalDateTime.now();
    }

}
