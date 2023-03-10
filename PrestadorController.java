package br.com.fiap.appservico.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.appservico.Models.Prestador;

// classe de controle para teste da classe Prestador
@RestController
public class PrestadorController {

    // contrução de uma classe Prestador
    Prestador prestador = new Prestador("Gabriel", "Gabriel123", "123.456.789-11", 20, '0');

    // função de mapeamento, para colocar na aplicação uma página que exibe o perfil do prestador
    @GetMapping("/Perfil")
    public Prestador perfil(){
        return prestador;
    }

    // função de mapeamento para colocar, na aplicação, uma função para atualizar o perfil do prestador
    @PutMapping("/Perfil")
    public Prestador perfilPut(@RequestBody Prestador prestador){
        return prestador;
    }

    // função de mapeamento para colocar, na aplicação, uma função que deleta o perfil do prestador
    @DeleteMapping("/Perfil")
    public boolean perfilDel(){
        return true;
    }
    
    //---------------------------------

    // função de mapeamento para colocar, na aplicação, uma página de login do prestador
    @GetMapping("/Login")
    public boolean login(@RequestBody String cpf, @RequestBody String senha){
        return true;
    }

    // função de mapeamento para colocar, na aplicação, uma página de registro do prestador
    @PostMapping("/Registro")
    public boolean registro(@RequestBody Prestador prestador){
        return true;
    }

}
