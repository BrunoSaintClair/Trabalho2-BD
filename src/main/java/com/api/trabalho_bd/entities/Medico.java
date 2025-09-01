package com.api.trabalho_bd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "medico")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedico")
    private int id;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String crm;
    private String telefone;
    private String nome;
    private String cpf;

    public Medico(LocalDate dataNascimento, String crm, String telefone, String nome, String cpf) {
        this.dataNascimento = dataNascimento;
        this.crm = crm;
        this.telefone = telefone;
        this.nome = nome;
        this.cpf = cpf;
    }

}
