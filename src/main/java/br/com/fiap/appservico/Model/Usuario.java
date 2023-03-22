package br.com.fiap.appservico.Model;

import java.util.ArrayList;

// classe do prestador de serviços, que extende a classe Verifica para usar seus métodos de verificação
public class Usuario {

	// atributos padrão
	private Long id;
	private String nome;
	private String senha;
	private String cpf;
	private int idade;

	// método da classe Usuário para criar uma publicação na plataforma
	public ArrayList publicar(Long usuId, String titulo, String descricao, Long id) {
		ArrayList info = new ArrayList();

		info.add(usuId);
		info.add(titulo);
		info.add(descricao);
		info.add(id);
		return info;
	}

	// contrutor com atributos
	public Usuario(Long id, String nome, String senha, String cpf, int idade) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.idade = idade;
	}

	// getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getcpf() {
		return cpf;
	}

	public void setcpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", cpf=" + cpf + ", idade=" + idade
				+ ", getId()=" + getId() + ", getNome()=" + getNome() + ", getSenha()=" + getSenha() + ", getcpf()="
				+ getcpf() + ", getIdade()=" + getIdade() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
