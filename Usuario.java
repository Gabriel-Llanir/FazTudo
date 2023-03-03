package br.com.fiap.appservico.Models;

import java.util.ArrayList;
import java.util.UUID;

import br.com.fiap.appservico.Utils.Verifica;

public class Usuario extends Verifica {
    
    private UUID id;
    private String nome;
    private String senha;
    private String cpf;
    private int idade;
    
    public ArrayList<String> publicar(String titulo, String descricao) {
        ArrayList<String> info = new ArrayList<String>();
        info.add(titulo);
        info.add(descricao);
        return info;
    }

    public Usuario(String nome, String senha, String cpf, int idade) {
        id = UUID.randomUUID();
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.idade = idade;
    }

    public Usuario() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
