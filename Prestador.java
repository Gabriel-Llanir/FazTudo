package br.com.fiap.appservico.Models;

import java.util.UUID;

import br.com.fiap.appservico.Utils.Verifica;

public class Prestador extends Verifica {
 
    private UUID id;
    private String nome;
    private String senha;
    private String cpf;
    private int idade;

    public Prestador(String nome, String senha, String cpf, int idade) {
        id = UUID.randomUUID();
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.idade = idade;
    }

    public Prestador() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
}
