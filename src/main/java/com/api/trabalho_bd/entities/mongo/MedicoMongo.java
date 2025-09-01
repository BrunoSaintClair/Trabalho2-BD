package com.api.trabalho_bd.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "medicos")
@Data
@NoArgsConstructor @AllArgsConstructor
public class MedicoMongo {
    @Id
    private String id;
    private LocalDate dataNascimento;
    private String crm;
    private String telefone;
    private String nome;
    private String cpf;

    public MedicoMongo(LocalDate dataNascimento, String crm, String telefone, String nome, String cpf) {
        this.dataNascimento = dataNascimento;
        this.crm = crm;
        this.telefone = telefone;
        this.nome = nome;
        this.cpf = cpf;
    }
}