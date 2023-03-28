package br.com.fiap.appservico.Domain.Prestador;

public record DadosDetalhamentoPrestador(Long id, String nome, String senha, String cpf, Integer idade,
                                         Boolean status) {

    public DadosDetalhamentoPrestador(Prestador prestador){
        this(prestador.getId(), prestador.getNome(), prestador.getSenha(), prestador.getCpf(), prestador.getIdade(),
                prestador.getStatus());
    }
}
