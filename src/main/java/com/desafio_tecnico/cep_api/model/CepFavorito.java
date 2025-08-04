package com.desafio_tecnico.cep_api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "cep_favoritos") // No MongoDB trabalhamos com documentos (@Document) e coleções, ao contrário do JPA (@Entity, @Table, etc.).
public class CepFavorito {
    @Id
    private String id;

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private LocalDateTime dataFavorito;

    @DBRef
    private Usuario usuario;
}
