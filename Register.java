package br.com.fiap.appservico.Pages;

import org.springframework.web.bind.annotation.PostMapping;

public class Register {
	
	@PostMapping("/initial/registerForm")
	public String registerForm() {
		return "Novo registro!";
	}
	
}
