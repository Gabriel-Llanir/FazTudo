package br.com.fiap.appservico.Pages;

import org.springframework.web.bind.annotation.GetMapping;

public class Initial {

	@GetMapping("/initial")
	public String initial() {
		return "Página inicial";
	}
	
}
