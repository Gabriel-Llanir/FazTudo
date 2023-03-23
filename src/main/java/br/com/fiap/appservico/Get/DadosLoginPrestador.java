package br.com.fiap.appservico.Get;

import br.com.fiap.appservico.Model.Prestador;

public record DadosLoginPrestador(Long id) {

    public DadosLoginPrestador(Prestador prestador){
        this(prestador.getId());
    }
}
