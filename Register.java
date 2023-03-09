package br.com.fiap.appservico.Pages;

import org.springframework.web.bind.annotation.PostMapping;

public class Register {
	
	@PostMapping("/Register")
	public String register() {
		return "Novo registro!";
	}
	
}
