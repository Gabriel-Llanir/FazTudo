package br.com.fiap.appservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// classe principal, usada para rodar a aplicação Spring
@SpringBootApplication
public class Main {

	// função para rodar a aplicação
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
