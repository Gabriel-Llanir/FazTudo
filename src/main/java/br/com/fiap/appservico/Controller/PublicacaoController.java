package br.com.fiap.appservico.Controller;

import br.com.fiap.appservico.Domain.Publicacao.*;
import br.com.fiap.appservico.Domain.Usuario.UsuarioRepository;
import br.com.fiap.appservico.Utils.PublicacaoPK;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("principal/publicacao")
@Transactional
public class PublicacaoController {

    @Autowired
    private PublicacaoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Publicacao> publicacao(){
        return repository.findAll();
    }

    @GetMapping("/{usuario_id}/{id}")
    public Optional<DadosMostrarPublicacao> publicacao(@PathVariable Long usuario_id, @PathVariable Long id){
        Optional<Publicacao> publicacao = repository.findById(new PublicacaoPK(id, usuario_id));
        var p1 = publicacao.map(p -> new DadosMostrarPublicacao(usuario_id, id, p.getTitulo(), p.getDescricao()));
        if(publicacao.isPresent())
            return p1;
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicação não encontrada!");
    }

    @PostMapping
    public void publicar(@RequestBody @Valid DadosRegistroPublicacao dados){
        var usuario = usuarioRepository.getReferenceById(dados.usuario_id());
        Publicacao publicacao = new Publicacao(dados);
        publicacao.setId(new PublicacaoPK());
        publicacao.getUsuario().setId(dados.usuario_id());
        usuario.getPublicacoes().add(publicacao);
        repository.save(publicacao);
    }

    @PutMapping("/{usuario_id}/{id}")
    public void publicacaoPut(@PathVariable Long usuario_id, @PathVariable Long id, @RequestBody @Valid DadosAtualizacaoPublicacao dados){
        var usuario = usuarioRepository.getReferenceById(usuario_id);
        PublicacaoPK publicacaoPK = new PublicacaoPK(id, usuario_id);
        usuario.setId(usuario_id);
        publicacaoPK.setId(id);
        Optional<Publicacao> publicacaoExistente = repository.findById(id);
        if(publicacaoExistente.isPresent()) {
            Publicacao publicacaoAtualizada = publicacaoExistente.get();
            publicacaoAtualizada.atualizarInformacoes(dados);
            repository.save(publicacaoAtualizada);
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicação não encontrada!");
    }

    @DeleteMapping("/{usuario_id}/{id}")
    public void publicacaoDel(@PathVariable Long usuario_id, @PathVariable Long id){
        var usuario = usuarioRepository.getReferenceById(usuario_id);
        PublicacaoPK publicacaoPK = new PublicacaoPK(id, usuario_id);
        usuario.setId(usuario_id);
        publicacaoPK.setId(id);
        Optional<Publicacao> publicacaoExistente = repository.findById(id);
        if(publicacaoExistente.isPresent()) {
            repository.delete(publicacaoExistente.get());
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicação não encontrada!");
    }
}
