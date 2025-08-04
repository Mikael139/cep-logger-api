package com.desafio_tecnico.cep_api.controller;

import com.desafio_tecnico.cep_api.dto.CepResponseDTO;
import com.desafio_tecnico.cep_api.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// responsável por lidar com as requisições de busca de CEP.
@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    // Endpoint para buscar o CEP
    // Exemplo: GET http://localhost:8080/cep/01001000
    @GetMapping("/{cep}")
    public ResponseEntity<CepResponseDTO> buscarCep(@PathVariable String cep) {
        CepResponseDTO response = cepService.buscarCep(cep);
        return ResponseEntity.ok(response);
    }
}