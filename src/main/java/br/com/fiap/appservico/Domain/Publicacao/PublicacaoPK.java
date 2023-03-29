package br.com.fiap.appservico.Domain.Publicacao;

import lombok.*;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicacaoPK implements Serializable {

    private Long usuarioId;
    private String titulo;
}
