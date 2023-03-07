package br.com.fiap.appservico.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.appservico.Models.Prestador;

// classe de controle para teste da classe Prestador
@RestController
public class PrestadorController {

    // contrução de uma classe Prestador
    Prestador prestador = new Prestador("Gabriel", "Gabriel123", "123.456.789-11", 20, '0');

    // função de mapeamento, para colocar na aplicação uma página que exibe a classe criada
    @GetMapping("/Prestador")
    public Prestador show(){
        return prestador;
    }

}
