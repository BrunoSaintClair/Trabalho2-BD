package com.api.trabalho_bd.services;

import com.api.trabalho_bd.dtos.forms.CreateConsultaForm;
import com.api.trabalho_bd.dtos.forms.UpdateConsultaForm;
import com.api.trabalho_bd.entities.Consulta;
import com.api.trabalho_bd.repositories.jpa.ConsultaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Consulta findById(long id) {
        return consultaRepository.findByIdConsulta(id);
    }

    public Consulta update(long id, UpdateConsultaForm dto) {
        Consulta consultaAntiga = consultaRepository.findByIdConsulta(id);

        if (dto.dataConsulta() != null) consultaAntiga.setDataConsulta(dto.dataConsulta());
        if (dto.horarioConsulta() != null) consultaAntiga.setHorarioConsulta(dto.horarioConsulta());
        if (dto.idMedico() != null) consultaAntiga.setIdMedico(dto.idMedico());
        if (dto.idPaciente() != null) consultaAntiga.setIdPaciente(dto.idPaciente());
        if (dto.tipoConsulta() != null) consultaAntiga.setTipoConsulta(dto.tipoConsulta());

        return consultaRepository.save(consultaAntiga);
    }

    public void delete(long id) {
        consultaRepository.delete(consultaRepository.findByIdConsulta(id));
    }

}
