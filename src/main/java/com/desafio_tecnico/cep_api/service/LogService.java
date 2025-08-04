package com.desafio_tecnico.cep_api.service;

import com.desafio_tecnico.cep_api.model.CepLog;
import com.desafio_tecnico.cep_api.repository.CepLogRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class LogService {

    private final CepLogRepository cepLogRepository;

    public LogService(CepLogRepository cepLogRepository) {
        this.cepLogRepository = cepLogRepository;
    }

    public void registrarLog(String cep, String resultadoJson) {
        CepLog log = new CepLog();
        log.setCepBuscado(cep);
        log.setResultado(resultadoJson);
        log.setDataConsulta(Instant.now());

        cepLogRepository.save(log);
    }
}
