package br.com.fiap.appservico.Models;

import java.util.ArrayList;
import java.util.UUID;

import br.com.fiap.appservico.Utils.Verifica;

// classe do prestador de serviços, que extende a classe Verifica para usar seus métodos de verificação
public class Usuario extends Verifica {

	// atributos padrão
	private UUID id;
	private String nome;
	private String senha;
	private String cpf;
	private int idade;
	private ArrayList<ArrayList<String>> publicacoes;

	// método da classe Usuário para criar uma publicação na plataforma
	public ArrayList<String> publicar(ArrayList<ArrayList<String>> array, String titulo, String descricao) {
		ArrayList<String> info = new ArrayList<String>();
		info.add(titulo);
		info.add(descricao);
		info.add("Id Publicação: " + UUID.randomUUID());
		array.add(info);
		return info;
	}

	// contrutor com atributos
	public Usuario(String nome, String senha, String cpf, int idade) {
		
		ArrayList<ArrayList<String>> publicacoes = new ArrayList<ArrayList<String>>();
		
		id = UUID.randomUUID();
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.idade = idade;
		this.publicacoes = publicacoes;
	}

	// getters e setters
	public UUID getId() {
		return id;
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

	public ArrayList<ArrayList<String>> getPublicacoes() {
		return publicacoes;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", cpf=" + cpf + ", idade=" + idade
				+ ", getId()=" + getId() + ", getNome()=" + getNome() + ", getSenha()=" + getSenha() + ", getcpf()="
				+ getcpf() + ", getIdade()=" + getIdade() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
