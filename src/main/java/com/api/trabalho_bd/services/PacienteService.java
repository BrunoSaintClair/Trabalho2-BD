package com.api.trabalho_bd.services;

import com.api.trabalho_bd.dtos.forms.CreatePacienteForm;
import com.api.trabalho_bd.dtos.forms.UpdatePacienteForm;
import com.api.trabalho_bd.entities.Paciente;
import com.api.trabalho_bd.repositories.jpa.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Paciente findById(int id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente com id " + id + " não encontrado."));
    }

    public Paciente update(int id, UpdatePacienteForm dto) {
        Optional<Paciente> pacienteAntigo = pacienteRepository.findById(id);

        if (pacienteAntigo.isEmpty()) {
            throw new RuntimeException("Paciente com id " + id + " não encontrado.");
        }

        Paciente novoCadastro = pacienteAntigo.get();

        if (dto.dataNascimento() != null) novoCadastro.setDataNascimento(dto.dataNascimento());
        if (dto.idHistoricoClinico() != null) novoCadastro.setIdHistoricoClinico(dto.idHistoricoClinico());
        if (dto.convenioCnpj() != null) novoCadastro.setConvenioCnpj(dto.convenioCnpj());
        if (dto.email() != null) novoCadastro.setEmail(dto.email());
        if (dto.telefone() != null) novoCadastro.setTelefone(dto.telefone());
        if (dto.registroGeral() != null) novoCadastro.setRegistroGeral(dto.registroGeral());
        if (dto.sexo() != null) novoCadastro.setSexo(dto.sexo());
        if (dto.nome() != null) novoCadastro.setNome(dto.nome());
        if (dto.cpf() != null) novoCadastro.setCpf(dto.cpf());

        return pacienteRepository.save(novoCadastro);
    }

    public void delete(int id) {
        pacienteRepository.delete(pacienteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Paciente com id " + id + " não encontrado.")
        ));
    }

}
