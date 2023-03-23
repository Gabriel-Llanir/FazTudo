package br.com.fiap.appservico.Post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosRegistroUsuario(@NotBlank String nome,
                                   @NotBlank String senha,
                                   @NotBlank String cpf,
                                   @NotNull @Pattern(regexp = "\\d{2}") int idade) {
}
