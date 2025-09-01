package com.api.trabalho_bd.entities.mongo;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.time.LocalDate;

@Document(collection = "procedimentos")
@Data
@NoArgsConstructor @AllArgsConstructor
public class ProcedimentoMongo {
    @Id
    private String id;
    private String tipo;
    private LocalDate dataAgendamento;
    private Time horarioAgendamento;
    private String status;
    private String pacienteId;
    private String medicoId;
    private String clinicaId;

    public ProcedimentoMongo(String tipo, LocalDate dataAgendamento, Time horarioAgendamento, String status, String pacienteId, String medicoId, String clinicaId) {
        this.tipo = tipo;
        this.dataAgendamento = dataAgendamento;
        this.horarioAgendamento = horarioAgendamento;
        this.status = status;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.clinicaId = clinicaId;
    }
}