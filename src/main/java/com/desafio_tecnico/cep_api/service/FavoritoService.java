package com.desafio_tecnico.cep_api.service;

import com.desafio_tecnico.cep_api.dto.CepResponseDTO;
import com.desafio_tecnico.cep_api.model.CepFavorito;
import com.desafio_tecnico.cep_api.model.Usuario;
import com.desafio_tecnico.cep_api.repository.CepFavoritoRepository;
import com.desafio_tecnico.cep_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FavoritoService {

    private final CepFavoritoRepository favoritoRepository;
    private final CepService cepService;
    private final UsuarioRepository usuarioRepository;

    public FavoritoService(CepFavoritoRepository favoritoRepository, CepService cepService, UsuarioRepository usuarioRepository) {
        this.favoritoRepository = favoritoRepository;
        this.cepService = cepService;
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Salva um CEP como favorito para um usuário.
     * @param email Email do usuário autenticado.
     * @param cep O número do CEP a ser favoritado.
     * @return O objeto CepFavorito salvo.
     */
    public CepFavorito favoritarCep(String email, String cep) {
        // Busca o usuário pelo email
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Busca as informações completas do CEP para salvar
        CepResponseDTO cepInfo = cepService.buscarCep(cep);

        // Cria o objeto CepFavorito
        CepFavorito favorito = new CepFavorito();
        favorito.setCep(cepInfo.getCep());
        favorito.setLogradouro(cepInfo.getLogradouro());
        favorito.setBairro(cepInfo.getBairro());
        favorito.setLocalidade(cepInfo.getLocalidade());
        favorito.setUf(cepInfo.getUf());
        favorito.setDataFavorito(LocalDateTime.now());
        favorito.setUsuario(usuario); // Associa o favorito ao usuário

        return favoritoRepository.save(favorito);
    }

    /**
     * Lista todos os CEPs favoritos de um usuário.
     * @param email Email do usuário autenticado.
     * @return Uma lista de CepFavorito.
     */
    public List<CepFavorito> listarFavoritos(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return favoritoRepository.findByUsuario(usuario);
    }

    /**
     * Remove um CepFavorito pelo seu ID.
     * @param id O ID do CepFavorito a ser removido.
     */
    public void desfavoritarCep(String id) {
        favoritoRepository.deleteById(id);
    }
}
