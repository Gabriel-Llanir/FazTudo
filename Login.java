package br.com.fiap.appservico.Pages;

import org.springframework.web.bind.annotation.GetMapping;

public class Login {

	@GetMapping("/initial/login")
	public String login() {
		return "Login na plataforma";
	}
	
}
