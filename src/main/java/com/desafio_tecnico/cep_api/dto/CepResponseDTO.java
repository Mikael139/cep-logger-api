package com.desafio_tecnico.cep_api.dto;

import lombok.Data;

@Data
public class CepResponseDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}

