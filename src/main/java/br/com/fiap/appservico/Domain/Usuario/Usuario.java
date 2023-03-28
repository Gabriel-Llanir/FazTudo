package br.com.fiap.appservico.Domain.Usuario;

import br.com.fiap.appservico.Domain.Publicacao.Publicacao;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

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
	private Integer idade;
	private Boolean ativo;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Publicacao> publicacoes = new ArrayList<>();

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
