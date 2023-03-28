package br.com.fiap.appservico.Utils;

import br.com.fiap.appservico.Model.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicacaoPK implements Serializable {

    private Long usuarioId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
