package br.com.fiap.appservico.Domain.Prestador;

public record DadosMostrarPrestador(Long id, String nome, String cpf, String senha, Integer idade, Boolean status, Boolean ativo) {

    public DadosMostrarPrestador(Prestador prestador){
        this(prestador.getId(), prestador.getNome(), prestador.getCpf(), prestador.getSenha(), prestador.getIdade(), prestador.getStatus(),
                prestador.getAtivo());
    }
}
