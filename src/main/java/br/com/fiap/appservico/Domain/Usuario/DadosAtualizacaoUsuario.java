package br.com.fiap.appservico.Domain.Usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(@NotNull Long id,
                                      String nome,
                                      String senha) {
}
