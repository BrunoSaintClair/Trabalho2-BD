package com.api.trabalho_bd.services;

import com.api.trabalho_bd.dtos.forms.CreateConsultaForm;
import com.api.trabalho_bd.dtos.forms.UpdateConsultaForm;
import com.api.trabalho_bd.entities.Consulta;
import com.api.trabalho_bd.repositories.jpa.ConsultaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultaService {

    @Autowired
    private final ConsultaRepository consultaRepository;

    public Consulta create(CreateConsultaForm dto) {
        return consultaRepository.save(new Consulta(dto.dataConsulta(), dto.horarioConsulta(),
                dto.idMedico(), dto.idPaciente(), dto.tipoConsulta())
        );
    }

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Consulta findById(int id) {
        return consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta com id " + id + " não encontrada."));
    }

    public Consulta update(int id, UpdateConsultaForm dto) {
        Optional<Consulta> consultaAntiga = consultaRepository.findById(id);

        if (consultaAntiga.isEmpty()) throw new RuntimeException("Consulta com id " + id + " não encontrada.");

        Consulta consulta = consultaAntiga.get();

        if (dto.dataConsulta() != null) consulta.setDataConsulta(dto.dataConsulta());
        if (dto.horarioConsulta() != null) consulta.setHorarioConsulta(dto.horarioConsulta());
        if (dto.idMedico() != null) consulta.setIdMedico(dto.idMedico());
        if (dto.idPaciente() != null) consulta.setIdPaciente(dto.idPaciente());
        if (dto.tipoConsulta() != null) consulta.setTipoConsulta(dto.tipoConsulta());

        return consultaRepository.save(consulta);
    }

    public void delete(int id) {
        consultaRepository.delete(consultaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Consulta com id " + id + " não encontrada."))
        );
    }

}
