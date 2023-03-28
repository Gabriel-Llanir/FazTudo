package br.com.fiap.appservico.Domain.Publicacao;

import br.com.fiap.appservico.Utils.PublicacaoPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
}
