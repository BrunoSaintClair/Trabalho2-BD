package com.api.trabalho_bd.services;

import com.api.trabalho_bd.dtos.forms.CreateMedicoForm;
import com.api.trabalho_bd.dtos.forms.UpdateMedicoForm;
import com.api.trabalho_bd.entities.Medico;
import com.api.trabalho_bd.repositories.jpa.MedicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Medico findById(long id) {
        return medicoRepository.findByIdMedico(id);
    }

    public Medico update(long id, UpdateMedicoForm dto) {
        Medico medicoAntigo = medicoRepository.findByIdMedico(id);

        if (dto.dataNascimento() != null) medicoAntigo.setDataNascimento(dto.dataNascimento());
        if (dto.crm() != null) medicoAntigo.setCrm(dto.crm());
        if (dto.telefone() != null) medicoAntigo.setTelefone(dto.telefone());
        if (dto.nome() != null) medicoAntigo.setNome(dto.nome());
        if (dto.cpf() != null) medicoAntigo.setCpf(dto.cpf());

        return medicoRepository.save(medicoAntigo);
    }

    public void delete(long id) {
        medicoRepository.delete(medicoRepository.findByIdMedico(id));
    }

}
