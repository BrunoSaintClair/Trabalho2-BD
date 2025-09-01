package com.api.trabalho_bd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "paciente")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private int id;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "id_historico_clinico")
    private int idHistoricoClinico;
    @Column(name = "convenio_cnpj")
    private String convenioCnpj;
    private String email;
    private String telefone;
    @Column(name = "registro_geral")
    private String registroGeral;
    private String sexo;
    private String nome;
    private String cpf;

    public Paciente(LocalDate dataNascimento, int idHistoricoClinico,
                    String convenioCnpj, String email, String telefone,
                    String registroGeral, String sexo,  String nome, String cpf) {
        this.dataNascimento = dataNascimento;
        this.idHistoricoClinico = idHistoricoClinico;
        this.convenioCnpj = convenioCnpj;
        this.email = email;
        this.telefone = telefone;
        this.registroGeral = registroGeral;
        this.sexo = sexo;
        this.nome = nome;
        this.cpf = cpf;
    }

}
