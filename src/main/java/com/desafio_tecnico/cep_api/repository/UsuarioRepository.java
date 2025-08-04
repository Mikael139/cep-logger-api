package com.desafio_tecnico.cep_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.desafio_tecnico.cep_api.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}