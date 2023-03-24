package br.com.fiap.appservico.Utils;

import br.com.fiap.appservico.Model.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PublicacaoPK implements Serializable {

    @Column(name = "usuId")
    private Long usuarioId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public PublicacaoPK(Long id, Long usuarioId){
        this.id=id;
        this.usuarioId=usuarioId;
    }

    public PublicacaoPK(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublicacaoPK)) return false;
        PublicacaoPK that = (PublicacaoPK) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUsuarioId(), that.getUsuarioId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsuarioId());
    }}
