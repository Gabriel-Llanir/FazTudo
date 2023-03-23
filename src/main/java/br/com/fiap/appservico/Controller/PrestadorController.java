package br.com.fiap.appservico.Controller;

import br.com.fiap.appservico.Get.DadosLoginPrestador;
import br.com.fiap.appservico.Get.DadosMostrarPrestador;
import br.com.fiap.appservico.Model.Prestador;
import br.com.fiap.appservico.Post.DadosRegistroPrestador;
import br.com.fiap.appservico.Put.DadosAtualizacaoPrestador;
import br.com.fiap.appservico.Repositories.PrestadorRepository;
import br.com.fiap.appservico.Utils.Verifica;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("prestador")
public class PrestadorController extends Verifica {

    @Autowired
    private PrestadorRepository repository;

    @GetMapping("/{id}")
    public Optional<DadosMostrarPrestador> prestador(@PathVariable Long id){
        return repository.findById(id).map(DadosMostrarPrestador::new);
    }

    @PutMapping
    @Transactional
    public void prestadorPut(@RequestBody @Valid DadosAtualizacaoPrestador dados) {
        var prestador = repository.getReferenceById(dados.id());
        prestador.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void prestadorDel(@PathVariable Long id){
        var prestador = repository.getReferenceById(id);
        prestador.excluir();
    }

    @PostMapping
    @Transactional
    public void registro(@RequestBody @Valid DadosRegistroPrestador dados) {
        repository.save(new Prestador(dados));
    }

    @GetMapping("/login")
    public Optional<DadosLoginPrestador> login(@RequestBody String cpf, @RequestBody String senha){
        return repository.findByCpfAndSenha(cpf, senha);
    }
}
