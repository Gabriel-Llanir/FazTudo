package br.com.fiap.appservico.Controllers;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.appservico.Models.Usuario;

// classe de controle para teste da classe Usuario
@RestController
public class UsuarioController {

    // contrução de uma classe Usuario
    Usuario usuario = new Usuario("Gabriel", "Gabriel123", "123.456.789-11", 20);

    // função de mapeamento, para colocar na aplicação uma página que exibe a classe criada
    @GetMapping("/Usuario")
    public Usuario show(){
        return usuario;
    }

    /*
    função de mapeamento
    para colocar na aplicação uma página
    que exibe o funcionamento da função de publicação da classe Usuario
    */
    @GetMapping("/Usuario/publicar")
    public ArrayList<String> publicar() {
        ArrayList<String> publicacao = new ArrayList<String>();
        publicacao = usuario.publicar("Publicação legal", "Esta é uma publicação muito legal!");
        return publicacao;
    }

}
