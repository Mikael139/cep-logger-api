package com.desafio_tecnico.cep_api.service;

import com.desafio_tecnico.cep_api.model.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.desafio_tecnico.cep_api.repository.UsuarioRepository;
import com.desafio_tecnico.cep_api.dto.AuthRequestDTO;

import java.util.Optional;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder; // Injetando o encoder de senha

    // Construtor para injeção de dependências
    public AuthService(UsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // Lógica de login com senha hasheada
    public Optional<Usuario> login(AuthRequestDTO dto) {
        // 1. Busca o usuário pelo email
        Optional<Usuario> usuarioOpt = usuarioRepo.findByEmail(dto.getEmail());

        // 2. Se o usuário existir, verifica se a senha fornecida corresponde ao hash
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            // passwordEncoder.matches(senha_texto_plano, senha_hasheada)
            if (passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty(); // Retorna vazio se não encontrar ou a senha estiver incorreta
    }

    // Lógica de registro com hash da senha
    public Usuario register(AuthRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        // Hasheando a senha antes de salvar
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        return usuarioRepo.save(usuario);
    }
}