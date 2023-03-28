package br.com.fiap.appservico.Domain.Usuario;

import br.com.fiap.appservico.Domain.Publicacao.Publicacao;

public record DadosListagemPublicacoes(Long id, String titulo, String descricao) {

    public DadosListagemPublicacoes(Publicacao publicacao){
        this(publicacao.getId().getId(), publicacao.getTitulo(), publicacao.getDescricao());
    }
}
