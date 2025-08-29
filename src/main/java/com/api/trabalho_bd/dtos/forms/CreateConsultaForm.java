package com.api.trabalho_bd.dtos.forms;

import java.sql.Time;
import java.time.LocalDate;

public record CreateConsultaForm(LocalDate dataConsulta, Time horarioConsulta,
                                 int idMedico, int idPaciente,
                                 String tipoConsulta) {
}
