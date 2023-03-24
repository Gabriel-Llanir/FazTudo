package br.com.fiap.appservico.Repositories;

import br.com.fiap.appservico.Model.Publicacao;
import br.com.fiap.appservico.Utils.PublicacaoPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    Optional<Publicacao> findById(PublicacaoPK publicacaoIdObj);
}
