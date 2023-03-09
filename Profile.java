package br.com.fiap.appservico.Pages;

import org.springframework.web.bind.annotation.PatchMapping;

public class Profile {

	@PatchMapping("/Profile")
	public String profile() {
		return "Página de Perfil atualizada";
	}
	
}
