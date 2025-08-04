package com.desafio_tecnico.cep_api.repository;

import com.desafio_tecnico.cep_api.model.CepLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CepLogRepository extends MongoRepository<CepLog, String> {
}
