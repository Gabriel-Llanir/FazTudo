package br.com.fiap.appservico.Put;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(@NotNull Long id,
                                      String nome, String senha) {
}
