package br.com.fiap.appservico.Domain.Prestador;

public record DadosLoginPrestador(Long id) {

    public DadosLoginPrestador(Prestador prestador){
        this(prestador.getId());
    }
}
