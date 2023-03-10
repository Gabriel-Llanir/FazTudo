package br.com.fiap.appservico.Pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.appservico.Models.Usuario;

public class MainPage {

    Logger log = LoggerFactory.getLogger(MainPage.class);

    Usuario usuario = new Usuario();

    @PostMapping("/Main")
    public void mainPubli(@RequestBody String titulo, @RequestBody String desc) {
    	log.info("Publicação: " + usuario.publicar(titulo, desc));
    }

}
