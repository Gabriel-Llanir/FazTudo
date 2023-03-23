package br.com.fiap.appservico.Get;

import br.com.fiap.appservico.Model.Prestador;
import br.com.fiap.appservico.Model.Usuario;

public record DadosMostrarUsuario(Long id, String nome, String cpf, int idade, Boolean ativo) {

    public DadosMostrarUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCpf(), usuario.getIdade(), usuario.getAtivo());
    }
}
