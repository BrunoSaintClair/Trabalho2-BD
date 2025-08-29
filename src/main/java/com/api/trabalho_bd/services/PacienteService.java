package com.api.trabalho_bd.services;

import com.api.trabalho_bd.dtos.forms.CreatePacienteForm;
import com.api.trabalho_bd.dtos.forms.UpdatePacienteForm;
import com.api.trabalho_bd.entities.Paciente;
import com.api.trabalho_bd.repositories.jpa.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PacienteService {

    @Autowired
    private final PacienteRepository pacienteRepository;

    public Paciente create(CreatePacienteForm dto) {
        return pacienteRepository.save(new Paciente(dto.dataNascimento(), dto.idHistoricoClinico(), dto.convenioCnpj(),
                dto.email(), dto.telefone(), dto.registroGeral(), dto.sexo(), dto.nome(), dto.cpf()));
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente findById(long id) {
        return pacienteRepository.findByIdPaciente(id);
    }

    public Paciente update(long id, UpdatePacienteForm dto) {
        Paciente pacienteAntigo = pacienteRepository.findByIdPaciente(id);

        if (dto.dataNascimento() != null) pacienteAntigo.setDataNascimento(dto.dataNascimento());
        if (dto.idHistoricoClinico() != null) pacienteAntigo.setIdHistoricoClinico(dto.idHistoricoClinico());
        if (dto.convenioCnpj() != null) pacienteAntigo.setConvenioCnpj(dto.convenioCnpj());
        if (dto.email() != null) pacienteAntigo.setEmail(dto.email());
        if (dto.telefone() != null) pacienteAntigo.setTelefone(dto.telefone());
        if (dto.registroGeral() != null) pacienteAntigo.setRegistroGeral(dto.registroGeral());
        if (dto.sexo() != null) pacienteAntigo.setSexo(dto.sexo());
        if (dto.nome() != null) pacienteAntigo.setNome(dto.nome());
        if (dto.cpf() != null) pacienteAntigo.setCpf(dto.cpf());

        return pacienteRepository.save(pacienteAntigo);
    }

    public void delete(long id) {
        pacienteRepository.delete(pacienteRepository.findByIdPaciente(id));
    }

}
