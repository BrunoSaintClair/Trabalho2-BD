package com.api.trabalho_bd.dtos.forms;

import java.time.LocalDate;

public record CreateMedicoForm(LocalDate dataNascimento, String crm, String telefone,
                                String nome, String cpf) {
}
