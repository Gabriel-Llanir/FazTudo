package sla;

import org.springframework.web.bind.annotation.PatchMapping;

public class Profile {

	@PatchMapping("/profile")
	public String profile() {
		return "Página de Perfil atualizada";
	}
	
}
