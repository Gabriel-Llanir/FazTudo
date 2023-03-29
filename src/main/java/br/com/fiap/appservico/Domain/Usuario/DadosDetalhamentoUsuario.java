package br.com.fiap.appservico.Domain.Usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String senha, String cpf, Integer idade) {

    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getSenha(), usuario.getCpf(), usuario.getIdade());
    }
}
