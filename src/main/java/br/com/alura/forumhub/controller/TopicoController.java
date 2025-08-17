package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.dto.DadosCadastroTopico;
import br.com.alura.forumhub.model.Topico;
import br.com.alura.forumhub.model.Usuario;
import br.com.alura.forumhub.repository.TopicoRepository;
import br.com.alura.forumhub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topicos" )
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Topico> cadastrar(@RequestBody @Valid DadosCadastroTopico dados,
                                            UriComponentsBuilder uriBuilder,
                                            Authentication authentication) {

        // Busca o usuário logado
        Usuario autor = usuarioRepository.findUsuarioByEmail(authentication.getName());

        // Cria o novo tópico
        Topico topico = new Topico();
        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());
        topico.setAutor(autor);

        // Salva no banco
        topicoRepository.save(topico);

        // Retorna 201 Created com a localização do recurso
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(topico);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalhar(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizar(@PathVariable Long id,
                                            @RequestBody @Valid DadosCadastroTopico dados) {
        Topico topico = topicoRepository.getReferenceById(id);

        // Aqui você implementaria a lógica de atualização
        // Por simplicidade, vamos apenas retornar o tópico atual

        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

