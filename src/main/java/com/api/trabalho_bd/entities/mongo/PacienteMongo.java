package com.api.trabalho_bd.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "pacientes")
@Data
@NoArgsConstructor @AllArgsConstructor
public class PacienteMongo {
    @Id
    private String id;
    private LocalDate dataNascimento;
    private String idHistoricoClinico;
    private String convenioCnpj;
    private String email;
    private String telefone;
    private String registroGeral;
    private String sexo;
    private String nome;
    private String cpf;

    public PacienteMongo(LocalDate dataNascimento, String idHistoricoClinico,
                         String convenioCnpj, String email, String telefone,
                         String registroGeral, String sexo, String nome, String cpf) {
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