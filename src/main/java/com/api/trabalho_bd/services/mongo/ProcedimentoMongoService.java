package com.api.trabalho_bd.services.mongo;

import com.api.trabalho_bd.dtos.forms.mongo.CreateProcedimentoMongoForm;
import com.api.trabalho_bd.dtos.forms.mongo.UpdateProcedimentoMongoForm;
import com.api.trabalho_bd.entities.mongo.ProcedimentoMongo;
import com.api.trabalho_bd.repositories.mongo.ProcedimentoMongoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProcedimentoMongoService {

    @Autowired
    private final ProcedimentoMongoRepository procedimentoRepository;

    public ProcedimentoMongo create(CreateProcedimentoMongoForm dto) {
        return procedimentoRepository.save(new ProcedimentoMongo(dto.tipo(), dto.dataAgendamento(), dto.horarioAgendamento(),
                dto.status(), dto.pacienteId(), dto.medicoId(), dto.clinicaId()));
    }

    public List<ProcedimentoMongo> findAll() {
        return procedimentoRepository.findAll();
    }

    public ProcedimentoMongo findById(String id) {
        return procedimentoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Procedimento com id " + id + " não encontrado"));
    }

    public ProcedimentoMongo update(String id, UpdateProcedimentoMongoForm dto) {
        Optional<ProcedimentoMongo> cadastroAntigo = procedimentoRepository.findById(id);

        if (cadastroAntigo.isEmpty()) throw new RuntimeException("Procedimento com id " + id + " não encontrado");

        ProcedimentoMongo novoCadastro = cadastroAntigo.get();

        if (dto.tipo() != null) novoCadastro.setTipo(dto.tipo());
        if (dto.dataAgendamento() != null) novoCadastro.setDataAgendamento(dto.dataAgendamento());
        if (dto.horarioAgendamento() != null) novoCadastro.setHorarioAgendamento(dto.horarioAgendamento());
        if (dto.status() != null) novoCadastro.setStatus(dto.status());
        if (dto.pacienteId() != null) novoCadastro.setPacienteId(dto.pacienteId());
        if (dto.medicoId() != null) novoCadastro.setMedicoId(dto.medicoId());
        if (dto.clinicaId() != null) novoCadastro.setClinicaId(dto.clinicaId());

        return procedimentoRepository.save(novoCadastro);
    }

    public void delete(String id) {
        ProcedimentoMongo procedimento = this.findById(id);
        procedimentoRepository.delete(procedimento);
    }

}
