package com.api.trabalho_bd.services.mongo;

import com.api.trabalho_bd.dtos.forms.mongo.CreateMedicoMongoForm;
import com.api.trabalho_bd.dtos.forms.mongo.UpdateMedicoMongoForm;
import com.api.trabalho_bd.entities.Medico;
import com.api.trabalho_bd.entities.mongo.MedicoMongo;
import com.api.trabalho_bd.repositories.mongo.MedicoMongoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicoMongoService {

    @Autowired
    private final MedicoMongoRepository medicoRepository;

    public MedicoMongo create(CreateMedicoMongoForm dto) {
        return medicoRepository.save(new MedicoMongo(dto.dataNascimento(), dto.crm(), dto.telefone(),
                dto.nome(), dto.cpf()));
    }

    public List<MedicoMongo> findAll() {
        return medicoRepository.findAll();
    }

    public MedicoMongo findById(String id) {
        return medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico com id " + id + " não encontrado."));
    }

    public MedicoMongo update(String id, UpdateMedicoMongoForm dto) {
        Optional<MedicoMongo> cadastroAntigo = medicoRepository.findById(id);

        if (cadastroAntigo.isEmpty()) throw new RuntimeException("Médico com id " + id + " não encontrado.");

        MedicoMongo medico = cadastroAntigo.get();

        if (dto.dataNascimento() != null) medico.setDataNascimento(dto.dataNascimento());
        if (dto.crm() != null) medico.setCrm(dto.crm());
        if (dto.telefone() != null) medico.setTelefone(dto.telefone());
        if (dto.nome() != null) medico.setNome(dto.nome());
        if (dto.cpf() != null) medico.setCpf(dto.cpf());

        return medicoRepository.save(medico);
    }

    public void delete(String id) {
        MedicoMongo medico = this.findById(id);
        medicoRepository.delete(medico);
    }

}
