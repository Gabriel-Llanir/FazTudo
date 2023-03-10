package br.com.fiap.appservico.Pages;

import org.springframework.web.bind.annotation.GetMapping;

public class Login {

	@GetMapping("/Login")
	public String login() {
		return "Informações do formulário de Login";
	}
	
}
