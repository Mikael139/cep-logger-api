package com.desafio_tecnico.cep_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CepApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CepApiApplication.class, args);
	}
}