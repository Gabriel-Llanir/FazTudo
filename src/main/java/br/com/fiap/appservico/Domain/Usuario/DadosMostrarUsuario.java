package br.com.fiap.appservico.Domain.Usuario;

public record DadosMostrarUsuario(Long id, String nome, String senha, String cpf, Integer idade, Boolean ativo) {

    public DadosMostrarUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getSenha(), usuario.getCpf(), usuario.getIdade(), usuario.getAtivo());
    }
}
