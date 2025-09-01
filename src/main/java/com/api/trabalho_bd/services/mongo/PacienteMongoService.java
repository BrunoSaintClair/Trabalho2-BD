package com.api.trabalho_bd.services.mongo;

import com.api.trabalho_bd.dtos.forms.mongo.CreatePacienteMongoForm;
import com.api.trabalho_bd.dtos.forms.mongo.UpdatePacienteMongoForm;
import com.api.trabalho_bd.entities.mongo.PacienteMongo;
import com.api.trabalho_bd.entities.mongo.ProcedimentoMongo;
import com.api.trabalho_bd.repositories.mongo.PacienteMongoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PacienteMongoService {

    @Autowired
    private PacienteMongoRepository pacienteRepository;

    public PacienteMongo create(CreatePacienteMongoForm dto) {
        return pacienteRepository.save(new PacienteMongo(dto.dataNascimento(), dto.idHistoricoClinico(), dto.convenioCnpj(),
                dto.email(), dto.telefone(), dto.registroGeral(), dto.sexo(), dto.nome(), dto.cpf()));
    }

    public List<PacienteMongo> findAll() {
        return pacienteRepository.findAll();
    }

    public PacienteMongo findById(String id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente com id " + id + " não encontrado."));
    }

    public PacienteMongo update(String id, UpdatePacienteMongoForm dto) {
        Optional<PacienteMongo> cadastroAntigo = pacienteRepository.findById(id);

        if (cadastroAntigo.isEmpty()) {
            throw new RuntimeException("Paciente com id " + id + " não encontrado.");
        }

        PacienteMongo novoCadastro = cadastroAntigo.get();

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

    public void delete(String id) {
        PacienteMongo paciente = this.findById(id);
        pacienteRepository.delete(paciente);
    }

}