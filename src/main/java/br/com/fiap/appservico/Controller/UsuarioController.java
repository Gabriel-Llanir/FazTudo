package br.com.fiap.appservico.Controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.appservico.Models.Usuario;
import br.com.fiap.appservico.Utils.Verifica;

// classe de controle para teste da classe Usuario
@RestController
public class UsuarioController extends Verifica {

    // construção de um array de Usuários
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    // criação de uma lista de publicações do Usuário
    ArrayList<ArrayList> publicacoes = new ArrayList<ArrayList>();

    // criação de uma variaável para controle de Id
    Long id1 = Long.valueOf(1);

    // criando um log
    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    //---------------------------------

    // função de mapeamento para colocar, na aplicação, uma página que exibe o perfil do usuário
    @GetMapping("/Perfil/{id}")
    public ResponseEntity<Usuario> perfil(@PathVariable Long id){
        var usuario = usuarios
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();

        if(usuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario.get());
    }

    // função de mapeamento para colocar, na aplicação, uma função para atualizar o perfil do usuário
    @PutMapping("/Perfil/{id}")
    public ResponseEntity<Usuario> perfilPut(@PathVariable Long id, @RequestBody Usuario usuario) {
        var usuarioExistente = usuarios
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();

        if(usuarioExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        usuario.setId(id);
        usuarios.remove(usuarioExistente.get());
        usuarios.add(usuario);

        return ResponseEntity.ok(usuario);
    }

    // função de mapeamento para colocar, na aplicação, uma função que deleta o perfil do usuário
    @DeleteMapping("/Perfil/{id}")
    public ResponseEntity<Usuario> perfilDel(@PathVariable Long id){
        var usuario = usuarios
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();

        if(usuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        usuarios.remove(usuario.get());
        return ResponseEntity.noContent().build();
    }
    
    //---------------------------------
    
    // função de mapeamento para colocar, na aplicação, uma página de login do usuário
    @GetMapping("/Login/{id}")
    public ResponseEntity<Usuario> login(@PathVariable Long id){
        var usuario = usuarios
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();

        if(usuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario.get());
    }

    // função de mapeamento para colocar, na aplicação, uma página de registro do usuário
    @PostMapping("/Registro")
    public ResponseEntity<Usuario> registro(@RequestBody Usuario usuario){
        if (verficacpf(usuario.getcpf()) && verificaIdade(usuario.getIdade())){
            log.info("Registrando usuário: "+usuario);
            usuarios.add(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }
    

    /*
    função de mapeamento
    para colocar, na aplicação, uma página
    que exibe o funcionamento da função de publicação da classe Usuario
    */
    @ResponseBody
    @PostMapping("/Principal/Publicar")
    public ResponseEntity<ArrayList> princPubli(@RequestBody Usuario usuario, @RequestBody String titulo, @RequestBody String descricao) {
        log.info("Registrando publicação: "+usuario);
        var publicacao = usuario.publicar(usuario.getId(), titulo, descricao, id1);
        publicacoes.add(publicacao);
        id1++;

        return ResponseEntity.status(HttpStatus.CREATED).body(publicacao);
    }

    @ResponseBody
    @GetMapping("/Principal/Publicacao/{id}")
    public ResponseEntity<ArrayList> princPubliGet(@PathVariable Long id) {
        var publicacao = publicacoes
                .stream()
                .filter(d -> d.get(3).equals(id))
                .findFirst();

        if(publicacao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publicacao.get());
    }

    @ResponseBody
    @PutMapping("/Principal/Publicacao/{id}")
    public ResponseEntity<ArrayList> princPubliPut(@PathVariable Long id, @RequestBody ArrayList publi) {
        var usuId = publi.get(0);
        var titulo = publi.get(1);
        var desc = publi.get(2);
        var publiExistente = publicacoes
                .stream()
                .filter(d -> d.get(3).equals(id))
                .findFirst();

        if(publiExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        publi.set(0, usuId);
        publi.set(1, titulo);
        publi.set(2, desc);
        publicacoes.remove(publiExistente.get());
        publicacoes.add(publi);

        return ResponseEntity.ok(publi);
    	
    }

    @ResponseBody
    @DeleteMapping("/Principal/Publicacao/{id}")
    public ResponseEntity<Usuario> princPubliDel(@PathVariable Long id) {
        int n = 0;
        if(publicacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            for(int i = 0; i < publicacoes.size(); i++) {
                var publi = publicacoes.get(i);
                var id1 = publi.get(3);

                if (id1.equals(id)){
                    publicacoes.remove(publi);
                    return ResponseEntity.noContent().build();
                    n++;
                }
            }
        }
        if (n != 0) {
            return ResponseEntity.notFound().build();
        }
    }

}
