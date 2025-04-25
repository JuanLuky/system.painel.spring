package com.hospital.system.painel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_consultorio")
public class Consultorio {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String nome;

    private boolean ativo = true;

    public Consultorio() {}

}
