package br.com.fiap.appservico.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.appservico.Models.Prestador;

@RestController
public class PrestadorController {
    
    Prestador prestador = new Prestador("Gabriel", "Gabriel123", "123.456.789-11", 20);
    
    @GetMapping("/Prestador")
    public Prestador show(){
        return prestador;
    }

}
