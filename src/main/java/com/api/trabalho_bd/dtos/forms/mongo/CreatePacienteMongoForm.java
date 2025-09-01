package com.api.trabalho_bd.dtos.forms.mongo;

import java.time.LocalDate;

public record CreatePacienteMongoForm(
        LocalDate dataNascimento,
        String idHistoricoClinico,
        String convenioCnpj,
        String email,
        String telefone,
        String registroGeral,
        String sexo,
        String nome,
        String cpf
) {
}
