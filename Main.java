package br.com.fiap.appservico.Pages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.fiap.appservico.Models.Usuario;

public class Main {

	Usuario usuario = new Usuairo();	
	
	@GetMapping("/main")
	public String main() {
		return "Página Principal";
	}
	
	@PostMapping("/main/publicar")
	public ArrayList<String> mainPubli() {
		return usuario.publicar;
	}
	
}
