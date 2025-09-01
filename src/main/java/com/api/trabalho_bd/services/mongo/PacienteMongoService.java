package com.api.trabalho_bd.services.mongo;

import com.api.trabalho_bd.entities.mongo.PacienteMongo;
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

    public PacienteMongo create(PacienteMongo paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<PacienteMongo> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<PacienteMongo> findById(String id) {
        return pacienteRepository.findById(id);
    }

    public PacienteMongo update(PacienteMongo paciente) {
        return pacienteRepository.save(paciente);
    }

    public void delete(String id) {
        pacienteRepository.deleteById(id);
    }

}