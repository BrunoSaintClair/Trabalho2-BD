package com.api.trabalho_bd.dtos.forms;

import java.sql.Time;
import java.time.LocalDate;

public record UpdateConsultaForm(LocalDate dataConsulta, Time horarioConsulta,
                                 Integer idMedico, Integer idPaciente,
                                 String tipoConsulta) {
}
