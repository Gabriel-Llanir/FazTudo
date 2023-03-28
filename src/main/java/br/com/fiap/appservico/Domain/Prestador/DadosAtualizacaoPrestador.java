package br.com.fiap.appservico.Domain.Prestador;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPrestador(@NotNull Long id,
                                        String nome,
                                        String senha) {
}
