package com.desafio_tecnico.cep_api.repository;

import com.desafio_tecnico.cep_api.model.CepFavorito;
import com.desafio_tecnico.cep_api.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CepFavoritoRepository extends MongoRepository<CepFavorito, String> {

    // Método para buscar todos os CepFavorito de um usuário específico
    // O Spring Data MongoDB irá automaticamente gerar a query a partir do nome do método
    List<CepFavorito> findByUsuario(Usuario usuario);
}
