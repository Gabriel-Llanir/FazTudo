package br.com.fiap.appservico.Domain.Prestador;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="prestadores")
@Entity(name="Prestador")
public class Prestador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;
    private String cpf;
    private Integer idade;
    private Boolean status;
    private Boolean ativo;

    public Prestador(DadosRegistroPrestador dados) {
        this.ativo = true;
        this.status = false;
        this.nome = dados.nome();
        this.senha = dados.senha();
        this.cpf = dados.cpf();
        this.idade = dados.idade();
    }

    public void atualizarInformacoes(DadosAtualizacaoPrestador dados) {
        if (dados.nome()!=null)
            this.nome = dados.nome();
        if (dados.senha()!=null)
            this.senha = dados.senha();
    }

    public void excluir() {
        this.ativo = false;
    }
}
