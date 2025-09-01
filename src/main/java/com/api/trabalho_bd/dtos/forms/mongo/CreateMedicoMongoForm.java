package com.api.trabalho_bd.dtos.forms.mongo;

import java.time.LocalDate;

public record CreateMedicoMongoForm(
        LocalDate dataNascimento,
        String crm,
        String telefone,
        String nome,
        String cpf
) {
}
