package com.desafio_tecnico.cep_api.service;

import com.desafio_tecnico.cep_api.client.ViaCepClient;
import com.desafio_tecnico.cep_api.dto.CepResponseDTO;
import com.desafio_tecnico.cep_api.model.CepLog;
import com.desafio_tecnico.cep_api.repository.CepLogRepository;
import org.springframework.stereotype.Service;

import java.time.Instant; // <- Importe Instant
// import java.time.LocalDateTime; // <- Remova esta importação se não for mais necessária

@Service
public class CepService {

    private final ViaCepClient viaCepClient;
    private final CepLogRepository cepLogRepository;

    public CepService(ViaCepClient viaCepClient, CepLogRepository cepLogRepository) {
        this.viaCepClient = viaCepClient;
        this.cepLogRepository = cepLogRepository;
    }

    public CepResponseDTO buscarCep(String cep) {
        // Consulta o CEP usando o Feign Client
        CepResponseDTO response = viaCepClient.buscarCep(cep);

        // Registra o log da consulta
        CepLog log = new CepLog();
        log.setCepBuscado(cep);
        log.setResultado(response.toString()); // Ou converta para JSON se quiser
        log.setDataConsulta(Instant.now()); // <- Use Instant.now() aqui

        cepLogRepository.save(log);

        return response;
    }
}