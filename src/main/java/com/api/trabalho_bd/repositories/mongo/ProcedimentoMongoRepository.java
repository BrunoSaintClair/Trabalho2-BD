package com.api.trabalho_bd.repositories.mongo;

import com.api.trabalho_bd.entities.mongo.ProcedimentoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentoMongoRepository extends MongoRepository<ProcedimentoMongo, String> {
}