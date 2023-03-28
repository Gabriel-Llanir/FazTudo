package br.com.fiap.appservico.Domain.Publicacao;

public record DadosMostrarPublicacao(Long usuario_Id, Long id, String titulo, String descricao) {

    public DadosMostrarPublicacao(Publicacao publicacao){
        this(publicacao.getUsuario().getId(), publicacao.getId().getId(), publicacao.getTitulo(), publicacao.getDescricao());
    }
}
