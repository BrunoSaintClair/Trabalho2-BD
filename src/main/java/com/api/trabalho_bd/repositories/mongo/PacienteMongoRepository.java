package com.api.trabalho_bd.repositories.mongo;

import com.api.trabalho_bd.entities.mongo.PacienteMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteMongoRepository extends MongoRepository<PacienteMongo, String> {
}