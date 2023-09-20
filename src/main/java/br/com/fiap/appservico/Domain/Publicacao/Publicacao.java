package br.com.fiap.appservico.Domain.Publicacao;

import br.com.fiap.appservico.Domain.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="publicacoes")
@Entity(name="Publicacao")
@IdClass(PublicacaoPK.class)
public class Publicacao extends RepresentationModel<Publicacao> {

    @Id
    @Column(insertable=false, updatable=false)
    private Long usuario_id;

    @Id
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @JsonBackReference
    private Usuario usuario;

    private String descricao;

    public Publicacao(DadosRegistroPublicacao dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
    }

    public void atualizarInformacoes(DadosAtualizacaoPublicacao dados){
        if (dados.titulo()!=null)
            this.titulo = dados.titulo();

        if (dados.descricao()!=null)
            this.descricao = dados.descricao();
    }
}
