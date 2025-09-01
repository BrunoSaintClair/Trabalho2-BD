package com.api.trabalho_bd.repositories.mongo;

import com.api.trabalho_bd.entities.mongo.MedicoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoMongoRepository extends MongoRepository<MedicoMongo, String> {
}