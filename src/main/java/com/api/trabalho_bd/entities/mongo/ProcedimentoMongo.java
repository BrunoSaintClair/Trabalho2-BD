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

}