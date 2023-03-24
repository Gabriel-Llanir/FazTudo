package br.com.fiap.appservico.Post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public record DadosRegistroPrestador(@NotBlank String nome,
                                     @NotBlank String senha,
                                     @NotBlank String cpf,
                                     @NotNull @Range(min = 18, max = 100) Integer idade) {
}
