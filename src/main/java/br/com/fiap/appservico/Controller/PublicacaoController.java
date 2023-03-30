package br.com.fiap.appservico.Controller;

import br.com.fiap.appservico.Domain.Publicacao.*;
import br.com.fiap.appservico.Domain.Usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("principal/publicacao")
@Transactional
public class PublicacaoController {

    @Autowired
    private PublicacaoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Publicacao>> publicacao(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity publicacao(@PathVariable Long id){
        var publicacao = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosMostrarPublicacao(publicacao));
    }

    @PostMapping
    public ResponseEntity publicar(@RequestBody @Valid DadosRegistroPublicacao dados, UriComponentsBuilder uriBuilder){
        var usuario = usuarioRepository.getReferenceById(dados.usuario_id());
        var publicacao = new Publicacao(dados);
        var pk = new PublicacaoPK(publicacao.getUsuario().getId(), publicacao.getTitulo());
        publicacao.setId(pk);
        publicacao.setUsuario(usuario);
        usuario.getPublicacoes().add(publicacao);
        repository.save(publicacao);

        var uri = uriBuilder.path("/principal/publicacao").buildAndExpand(publicacao.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPublicacao(publicacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity publicacaoPut(@PathVariable Long id,
                                        @RequestBody @Valid DadosAtualizacaoPublicacao dados){
        var publicacao = repository.getReferenceById(id);
        publicacao.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPublicacao(publicacao));
    }

    @DeleteMapping("/{usuario_id}/{id}")
    public ResponseEntity publicacaoDel(@PathVariable Long usuario_id, @PathVariable Long id){
        repository.deleteById(id);
        var usuario = usuarioRepository.getReferenceById(usuario_id);
        if (!usuario.excluirPublicacao(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
