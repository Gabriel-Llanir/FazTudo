package br.com.fiap.appservico.Domain.Usuario;

public record DadosLoginUsuario(Long id) {

    public DadosLoginUsuario(Usuario usuario){
        this(usuario.getId());
    }
}
