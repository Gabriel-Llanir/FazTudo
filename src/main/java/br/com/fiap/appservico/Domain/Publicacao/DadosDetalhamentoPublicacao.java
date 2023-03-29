package br.com.fiap.appservico.Domain.Publicacao;

public record DadosDetalhamentoPublicacao(Long usuId, String titulo, String descricao) {

    public DadosDetalhamentoPublicacao(Publicacao publicacao){
        this(publicacao.getUsuario().getId(), publicacao.getTitulo(), publicacao.getDescricao());
    }
}
