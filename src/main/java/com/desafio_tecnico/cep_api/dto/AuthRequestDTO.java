package com.desafio_tecnico.cep_api.dto;

import lombok.Data;

@Data
public class AuthRequestDTO {
    private String email;
    private String senha;
}

