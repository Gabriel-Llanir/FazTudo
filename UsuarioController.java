package br.com.fiap.appservico.Controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.appservico.Models.Usuario;

// classe de controle para teste da classe Usuario
@RestController
public class UsuarioController {

    // construção de uma lista de Usuários
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    // contrução de uma classe Usuário
    Usuario usuario = new Usuario(1, "Gabriel", "Gabriel123", "123.456.789-11", 20);

    //---------------------------------

    // criando um log
    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    //---------------------------------

    // função de mapeamento para colocar, na aplicação, uma página que exibe o perfil do usuário
    @GetMapping("/Perfil/{id}")
    public ResponseEntity<Usuario> perfil(@PathVariable long id){
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
    public void atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {

    }

    // função de mapeamento para colocar, na aplicação, uma função que deleta o perfil do usuário
    @DeleteMapping("/Perfil/{id}")
    public ResponseEntity<Usuario> perfilDel(@PathVariable long id){
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
    public ResponseEntity<Usuario> login(@PathVariable long id){
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
        log.info("Registrando usuário: "+usuario);
        usuarios.add(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    

    /*
    função de mapeamento
    para colocar, na aplicação, uma página
    que exibe o funcionamento da função de publicação da classe Usuario
    */
    @ResponseBody
    @PostMapping("/Principal/Publicar")
    public ResponseEntity<ArrayList<String>> princPubli(@RequestBody Usuario usuario, String titulo, @RequestBody String descricao) {
        log.info("Registrando publicação: "+usuario);
        var publicacao = usuario.publicar(titulo, descricao, 1);
        var publicacoes = usuario.arrayPublis(publicacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(publicacao);
    }
    
    @GetMapping("/Principal/Publicacao/{id}")
    public void princPubliGet() {
    	
    }
    
    @PutMapping("/Principal/Publicacao/{id}")
    public void princPubliPut() {
    	
    }
    
    @DeleteMapping("/Principal/Publicacao/{id}")
    public void princPubliDel() {
    	
    }

}
