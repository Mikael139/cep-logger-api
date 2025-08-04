package com.desafio_tecnico.cep_api.controller;

import com.desafio_tecnico.cep_api.dto.AuthRequestDTO;
import com.desafio_tecnico.cep_api.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desafio_tecnico.cep_api.service.AuthService;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    // injeção do serviço de autenticação.
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // rota de login.
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequestDTO dto) {
        Optional<Usuario> user = authService.login(dto);
        if (user.isPresent()) {
            return ResponseEntity.ok("Login OK: ID " + user.get().getId());
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }

    //rota de registro / cadastro
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequestDTO dto) {
        Usuario registeredUser = authService.register(dto);
        return ResponseEntity.ok("Usuário " + registeredUser.getEmail() + " cadastrado com sucesso");
    }
}