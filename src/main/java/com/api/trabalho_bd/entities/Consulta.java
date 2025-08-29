package com.api.trabalho_bd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "consulta")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private int idConsulta;
    @Column(name = "data_consulta")
    private LocalDate dataConsulta;
    @Column(name = "horario_consulta")
    private Time horarioConsulta;
    @Column(name = "id_medico")
    private int idMedico;
    @Column(name = "id_paciente")
    private int idPaciente;
    @Column(name = "tipo_consulta")
    private String tipoConsulta;

    public Consulta(LocalDate dataConsulta, Time horarioConsulta, int idMedico, int idPaciente, String tipoConsulta) {
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.tipoConsulta = tipoConsulta;
    }
}
