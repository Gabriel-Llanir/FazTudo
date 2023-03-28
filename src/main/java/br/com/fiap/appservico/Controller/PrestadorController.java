package br.com.fiap.appservico.Controller;

import br.com.fiap.appservico.Domain.Prestador.*;
import br.com.fiap.appservico.Domain.Usuario.DadosLoginUsuario;
import br.com.fiap.appservico.Utils.Verifica;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("prestador")
public class PrestadorController extends Verifica {

    @Autowired
    private PrestadorRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity prestador(@PathVariable Long id){
        var prestador = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosMostrarPrestador(prestador));
    }

    @PutMapping
    @Transactional
    public ResponseEntity prestadorPut(@RequestBody @Valid DadosAtualizacaoPrestador dados) {
        var prestador = repository.getReferenceById(dados.id());
        prestador.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPrestador(prestador));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity prestadorExcluir(@PathVariable Long id){
        var prestador = repository.getReferenceById(id);
        prestador.excluir();

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/remove/{id}")
    @Transactional
    public ResponseEntity prestadorDel(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity registro(@RequestBody @Valid DadosRegistroPrestador dados, UriComponentsBuilder uriBuilder) {
        var prestador = new Prestador(dados);
        repository.save(prestador);

        var uri = uriBuilder.path("/prestadores/{id}").buildAndExpand(prestador.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPrestador(prestador));
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody String cpf, @RequestBody String senha){
        var prestador = repository.findByCpf(cpf);
        if (prestador.getSenha().equals(senha))
            return ResponseEntity.ok(new DadosLoginPrestador(prestador));
        else
            return ResponseEntity.badRequest().body("Senha inválida!");
    }
}
