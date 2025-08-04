package com.desafio_tecnico.cep_api.client;

import com.desafio_tecnico.cep_api.dto.CepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient define um cliente de serviço Feign
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

    // Define o método para buscar um CEP
    // O Feign é responsável por construir a URL: https://viacep.com.br/ws/{cep}/json/
    @GetMapping("/{cep}/json/")
    CepResponseDTO buscarCep(@PathVariable("cep") String cep);

}