package br.com.fiap.appservico.Model;

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
@Embeddable
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuId;
    private String titulo;
    private String descricao;

}
