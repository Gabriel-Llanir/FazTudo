package br.com.fiap.appservico.Models;

// classe do prestador de serviços, que extende a classe Verifica para usar seus métodos de verificação
public class Prestador {

    // atributos padrão
    private Long id;
    private String nome;
    private String senha;
    private String cpf;
    private int idade;

    // atributo especial para verificação
    private char status;

    // construtor com atributos
    public Prestador(Long id, String nome, String senha, String cpf, int idade, char status) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.idade = idade;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "Prestador [id=" + id + ", nome=" + nome + ", senha=" + senha + ", cpf=" + cpf + ", idade=" + idade
				+ ", status=" + status + ", getId()=" + getId() + ", getNome()=" + getNome() + ", getSenha()="
				+ getSenha() + ", getcpf()=" + getcpf() + ", getIdade()=" + getIdade() + ", getStatus()=" + getStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
    
}
