package com.desafio_tecnico.cep_api.controller;

import com.desafio_tecnico.cep_api.model.CepFavorito;
import com.desafio_tecnico.cep_api.service.FavoritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    private final FavoritoService favoritoService;

    // Injeção do serviço que contém a lógica de favoritar, listar e remover CEP's salvos pelo usuário.
    public FavoritoController(FavoritoService favoritoService) {
        this.favoritoService = favoritoService;
    }

    // método para salvar um CEP como favorito.
    @PostMapping
    public ResponseEntity<CepFavorito> favoritarCep(@RequestParam String cep, Principal principal) {
        // O principal.getName() retorna o "username" do usuário, que neste caso é o email
        CepFavorito favorito = favoritoService.favoritarCep(principal.getName(), cep);
        return ResponseEntity.ok(favorito);
    }

    // lista todos os CEPs favoritos do usuário logado.
    @GetMapping
    public ResponseEntity<List<CepFavorito>> listarFavoritos(Principal principal) {
        List<CepFavorito> favoritos = favoritoService.listarFavoritos(principal.getName());
        return ResponseEntity.ok(favoritos);
    }

    // Retorna uma lista com todos os favoritos em formato JSON.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desfavoritarCep(@PathVariable String id) {
        favoritoService.desfavoritarCep(id);
        return ResponseEntity.noContent().build();
    }
}
