package br.com.fiap.appservico.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.appservico.Models.Usuario;

@RestController
public class UsuarioController {

    Usuario usuario = new Usuario("Gabriel", "Gabriel123", "123.456.789-11", 20);
    
    @GetMapping("/Usuario")
    public Usuario show(){
        return usuario;
    }

    @GetMapping("/Usuario/publish")
    public ArrayList<String> publish() {
        ArrayList<String> publicacao = new ArrayList<String>();
        publicacao = usuario.publicar("Publicação legal", "Esta é uma publicação muito legal!");
        return publicacao;
    }

}
