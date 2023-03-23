package br.com.fiap.appservico.Get;

import br.com.fiap.appservico.Model.Prestador;

public record DadosMostrarPrestador(Long id, String nome, String cpf, int idade, char status, Boolean ativo) {

    public DadosMostrarPrestador(Prestador prestador){
        this(prestador.getId(), prestador.getNome(), prestador.getCpf(), prestador.getIdade(), prestador.getStatus(),
                prestador.getAtivo());
    }
}
