package br.com.fiap.appservico.Post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosRegistroPublicacao(@NotNull Long usuario_id,
                                      @NotBlank String titulo,
                                      @NotBlank String descricao) {
}
