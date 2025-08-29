package com.api.trabalho_bd.dtos.forms;

import java.time.LocalDate;

public record UpdateMedicoForm(LocalDate dataNascimento, String crm, String telefone,
                               String nome, String cpf) {
}
