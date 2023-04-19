package br.com.fiap.appservico.Domain.Publicacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    Page<Publicacao> findAll(Pageable paginacao);
}
