package com.desafio_tecnico.cep_api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "user")
public class Usuario {
    @Id
    private String id;

    private String email;
    private String senha;

    @DBRef
    private List<CepFavorito> favoritos;
}


