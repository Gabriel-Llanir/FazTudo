package br.com.fiap.appservico.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.appservico.Models.Usuario;

// classe de controle para teste da classe Usuario
@RestController
public class UsuarioController {

    // contrução de uma classe Usuario
    Usuario usuario = new Usuario("Gabriel", "Gabriel123", "123.456.789-11", 20);
    
    //---------------------------------

    // função de mapeamento para colocar, na aplicação, uma página que exibe o perfil do usuário
    @GetMapping("/Perfil")
    public Usuario perfil(){
        return usuario;
    }

    // função de mapeamento para colocar, na aplicação, uma função para atualizar o perfil do usuário
    @PutMapping("/Perfil")
    public Usuario perfilPut(@RequestBody Usuario usuario){
        return usuario;
    }

    // função de mapeamento para colocar, na aplicação, uma função que deleta o perfil do usuário
    @DeleteMapping("/Perfil")
    public boolean perfilDel(){
        return true;
    }
    
    //---------------------------------
    
    // função de mapeamento para colocar, na aplicação, uma página de login do usuário
    @GetMapping("/Login")
    public boolean login(@RequestBody String cpf, @RequestBody String senha){
        return true;
    }

    // função de mapeamento para colocar, na aplicação, uma página de registro do usuário
    @PostMapping("/Registro")
    public boolean registro(@RequestBody Usuario usuario){
        return true;
    }
    

    /*
    função de mapeamento
    para colocar, na aplicação, uma página
    que exibe o funcionamento da função de publicação da classe Usuario
    */
    @ResponseBody
    @PostMapping("/Principal/Publicar")
    public ArrayList<String> princPubli(@RequestBody Usuario usuario, @RequestBody String titulo, @RequestBody String descricao) {
        return usuario.publicar(usuario.getPublicacoes(), titulo, descricao);
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
