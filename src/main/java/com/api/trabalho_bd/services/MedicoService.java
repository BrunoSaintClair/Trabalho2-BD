package com.api.trabalho_bd.services;

import com.api.trabalho_bd.dtos.forms.CreateMedicoForm;
import com.api.trabalho_bd.dtos.forms.UpdateMedicoForm;
import com.api.trabalho_bd.entities.Medico;
import com.api.trabalho_bd.repositories.jpa.MedicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicoService {

    @Autowired
    private final MedicoRepository medicoRepository;

    public Medico create(CreateMedicoForm dto) {
        return medicoRepository.save(new Medico(
                dto.dataNascimento(), dto.crm(), dto.telefone(), dto.nome(), dto.cpf()
                )
        );
    }

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Medico findById(int id) {
        return medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico com id " + id + " não encontrado."));
    }

    public Medico update(int id, UpdateMedicoForm dto) {
        Optional<Medico> medicoAntigo = medicoRepository.findById(id);

        if (medicoAntigo.isEmpty()) throw new RuntimeException("Médico com id " + id + " não encontrado.");

        Medico medico = medicoAntigo.get();

        if (dto.dataNascimento() != null) medico.setDataNascimento(dto.dataNascimento());
        if (dto.crm() != null) medico.setCrm(dto.crm());
        if (dto.telefone() != null) medico.setTelefone(dto.telefone());
        if (dto.nome() != null) medico.setNome(dto.nome());
        if (dto.cpf() != null) medico.setCpf(dto.cpf());

        return medicoRepository.save(medico);
    }

    public void delete(int id) {
        medicoRepository.delete(medicoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Médico com id " + id + " não encontrado.")
        ));
    }

}
