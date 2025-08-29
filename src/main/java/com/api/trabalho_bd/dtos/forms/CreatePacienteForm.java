package com.api.trabalho_bd.dtos.forms;

import java.time.LocalDate;

public record CreatePacienteForm(LocalDate dataNascimento, Integer idHistoricoClinico, String convenioCnpj,
                                 String email, String telefone, String registroGeral, String sexo, String nome, String cpf) {
}
