package br.com.fiap.appservico.Get;

import br.com.fiap.appservico.Model.Usuario;

public record DadosLoginUsuario(Long id) {

    public DadosLoginUsuario(Usuario usuario){
        this(usuario.getId());
    }
}
