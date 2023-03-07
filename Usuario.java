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

    // método da classe Usuário para criar uma publicação na plataforma
    public ArrayList<String> publicar(String titulo, String descricao) {
        ArrayList<String> info = new ArrayList<String>();
        info.add(titulo);
        info.add(descricao);
        return info;
    }

    // contrutor com atributos
    public Usuario(String nome, String senha, String cpf, int idade) {
        id = UUID.randomUUID();
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.idade = idade;
    }

    // contrutor padrão
    public Usuario() {
        super();
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
}
