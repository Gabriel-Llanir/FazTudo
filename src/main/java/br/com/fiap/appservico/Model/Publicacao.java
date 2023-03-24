package br.com.fiap.appservico.Model;

import br.com.fiap.appservico.Post.DadosRegistroPublicacao;
import br.com.fiap.appservico.Put.DadosAtualizacaoPublicacao;
import br.com.fiap.appservico.Utils.PublicacaoPK;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="publicacoes")
@Entity(name="Publicacao")
public class Publicacao {

    @EmbeddedId
    private PublicacaoPK id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @JsonBackReference
    private Usuario usuario;

    private String titulo;
    private String descricao;

    public Publicacao(DadosRegistroPublicacao dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
    }

    public Publicacao(Usuario usuario){
        this.setUsuario(usuario);
    }

    public void atualizarInformacoes(DadosAtualizacaoPublicacao dados){
        if (dados.titulo()!=null)
            this.titulo = dados.titulo();

        if (dados.descricao()!=null)
            this.descricao = dados.descricao();
    }
}
