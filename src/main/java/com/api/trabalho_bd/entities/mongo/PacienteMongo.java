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
    private LocalDate data_nascimento;
    private String idHistoricoClinico;
    private String convenioCnpj;
    private String email;
    private String telefone;
    private String registroGeral;
    private String sexo;
    private String nome;
    private String cpf;
}