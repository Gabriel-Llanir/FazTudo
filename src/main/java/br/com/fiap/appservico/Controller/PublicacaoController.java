package br.com.fiap.appservico.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.fiap.appservico.Domain.Publicacao.*;
import br.com.fiap.appservico.Domain.Usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("publicacao")
@Transactional
public class PublicacaoController {

    @Autowired
    private PublicacaoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/pageable")
    public ResponseEntity<Page<Publicacao>> publicacoes(@PageableDefault Pageable paginacao){
        var publicacoes = repository.findAll(paginacao);
        if (publicacoes.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            for (Publicacao publicacao: publicacoes) {
                Long id = publicacao.getUsuario_id();
                publicacao.add(linkTo(methodOn(PublicacaoController.class).publicacao(id)).withSelfRel());
            }
            return ResponseEntity.ok(publicacoes);
        }
    }

    @GetMapping
    public ResponseEntity publicacoes(){
        var publicacoes = repository.findAll();
        if (publicacoes.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            for (Publicacao publicacao: publicacoes) {
                Long id = publicacao.getUsuario_id();
                publicacao.add(linkTo(methodOn(PublicacaoController.class).publicacao(id)).withSelfRel());
            }
            return ResponseEntity.ok(publicacoes);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity publicacao(@PathVariable Long id){
        var publicacao = repository.getReferenceById(id);

        if (publicacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            publicacao.add(linkTo(methodOn(PublicacaoController.class).publicacoes()).withRel("Lista de Publicações"));
            return ResponseEntity.ok(new DadosMostrarPublicacao(publicacao));
        }
    }

    @PostMapping
    public ResponseEntity publicar(@RequestBody @Valid DadosRegistroPublicacao dados, UriComponentsBuilder uriBuilder){
        var usuario = usuarioRepository.getReferenceById(dados.usuario_id());
        var publicacao = new Publicacao(dados);
        var pk = new PublicacaoPK(publicacao.getUsuario().getId(), publicacao.getTitulo());
        publicacao.setUsuario_id(publicacao.getUsuario_id());
        publicacao.setUsuario(usuario);
        usuario.getPublicacoes().add(publicacao);
        repository.save(publicacao);

        var uri = uriBuilder.path("/principal/publicacao").buildAndExpand(publicacao.getUsuario_id()).toUri();

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
