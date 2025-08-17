package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.dto.DadosAutenticacao;
import br.com.alura.forumhub.dto.DadosTokenJWT;
import br.com.alura.forumhub.model.Usuario;
import br.com.alura.forumhub.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login" )
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager; // Dispara o processo de autenticação

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        // O DTO do Spring já converte o JSON em objeto Java
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());

        // O manager chama o AutenticacaoService para verificar a senha
        var authentication = manager.authenticate(authenticationToken);

        // Se a autenticação for bem-sucedida, gera o token
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        // Retorna o token no corpo da resposta
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
