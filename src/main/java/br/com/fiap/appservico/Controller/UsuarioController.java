package br.com.fiap.appservico.Controller;

import java.util.Optional;

import br.com.fiap.appservico.Get.DadosLoginUsuario;
import br.com.fiap.appservico.Get.DadosMostrarUsuario;
import br.com.fiap.appservico.Model.Usuario;
import br.com.fiap.appservico.Post.DadosRegistroUsuario;
import br.com.fiap.appservico.Put.DadosAtualizacaoUsuario;
import br.com.fiap.appservico.Repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.appservico.Utils.Verifica;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends Verifica {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/{id}")
    public Optional<DadosMostrarUsuario> usuario(@PathVariable Long id){
        return repository.findById(id).map(DadosMostrarUsuario::new);
    }

    @PutMapping
    @Transactional
    public void usuarioPut(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void usuarioDel(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.excluir();
    }

    @PostMapping
    @Transactional
    public void registro(@RequestBody @Valid DadosRegistroUsuario dados){
        repository.save(new Usuario(dados));
    }

    @GetMapping("/login")
    public Optional<DadosLoginUsuario> login(@RequestBody String cpf, @RequestBody String senha){
        return repository.findByCpfAndSenha(cpf, senha);
    }
}
