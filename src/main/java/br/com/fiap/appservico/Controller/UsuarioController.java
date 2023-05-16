package br.com.fiap.appservico.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.fiap.appservico.Domain.Usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.appservico.Utils.Verifica;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("usuario")
public class UsuarioController extends Verifica {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity usuario(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosMostrarUsuario(usuario));
    }

    @GetMapping("/{id}/publicacoes")
    public ResponseEntity publicacoes(@PathVariable Long id, @PageableDefault(size = 10) Pageable paginacao){
        var usuario = repository.getReferenceById(id);
        var publicacoes = usuario.getPublicacoes();
        if (publicacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            for (var publicacao: publicacoes) {
                Long idP = publicacao.getId().getUsuarioId();
                publicacao.add(linkTo(methodOn(PublicacaoController.class).publicacao(idP)).withSelfRel());
            }
            return ResponseEntity.ok(publicacoes);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity usuarioPut(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity usuarioExcluir(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.excluir();

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/remove/{id}")
    @Transactional
    public ResponseEntity usuarioDel(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity registro(@RequestBody @Valid DadosRegistroUsuario dados, UriComponentsBuilder uriBuilder){
        var usuario = new Usuario(dados);
        repository.save(usuario);

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }
}