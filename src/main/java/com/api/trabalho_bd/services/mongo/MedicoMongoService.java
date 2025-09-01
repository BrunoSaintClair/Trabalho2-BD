package com.api.trabalho_bd.services.mongo;

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

    public MedicoMongo create(MedicoMongo medico) {
        return medicoRepository.save(medico);
    }

    public List<MedicoMongo> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<MedicoMongo> findById(String id) {
        return medicoRepository.findById(id);
    }

    public MedicoMongo update(MedicoMongo medico) {
        return medicoRepository.save(medico);
    }

    public void delete(String id) {
        medicoRepository.deleteById(id);
    }

}
