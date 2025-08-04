package com.desafio_tecnico.cep_api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@Document(collection = "cep_logs") // Nome da coleção (tabela) no MongoDB
public class CepLog {
    @Id
    private String id;

    private String cepBuscado;
    private String resultado;
    private Instant dataConsulta;
}
