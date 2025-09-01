package com.api.trabalho_bd.dtos.forms.mongo;

import java.sql.Time;
import java.time.LocalDate;

public record UpdateProcedimentoMongoForm(
        String tipo,
        LocalDate dataAgendamento,
        Time horarioAgendamento,
        String status,
        String pacienteId,
        String medicoId,
        String clinicaId
) {
}
