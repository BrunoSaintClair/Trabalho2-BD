package com.api.trabalho_bd.services.mongo;

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

    public ProcedimentoMongo create(ProcedimentoMongo procedimento) {
        return procedimentoRepository.save(procedimento);
    }

    public List<ProcedimentoMongo> findAll() {
        return procedimentoRepository.findAll();
    }

    public Optional<ProcedimentoMongo> findById(String id) {
        return procedimentoRepository.findById(id);
    }

    public ProcedimentoMongo update(ProcedimentoMongo procedimento) {
        return procedimentoRepository.save(procedimento);
    }

    public void delete(String id) {
        procedimentoRepository.deleteById(id);
    }

}
