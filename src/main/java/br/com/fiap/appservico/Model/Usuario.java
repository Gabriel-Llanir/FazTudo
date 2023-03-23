package br.com.fiap.appservico.Model;

import br.com.fiap.appservico.Post.DadosRegistroUsuario;
import br.com.fiap.appservico.Put.DadosAtualizacaoUsuario;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usuarios")
@Entity(name="Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String senha;
	private String cpf;
	private int idade;
	private Boolean ativo;

	@Embedded
	private Publicacao publicacao;

	public Usuario(DadosRegistroUsuario dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.senha = dados.senha();
		this.cpf = dados.cpf();
		this.idade = dados.idade();
	}

	public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {
		if (dados.nome()!=null)
			this.nome= dados.nome();
		if (dados.senha()!=null)
			this.senha= dados.senha();
	}

	public void excluir() {
		this.ativo = false;
	}
}
