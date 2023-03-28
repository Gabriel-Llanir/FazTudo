package br.com.fiap.appservico.Domain.Usuario;

import br.com.fiap.appservico.Domain.Publicacao.Publicacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Page<Publicacao> findAllPublicacaoById(Long id, Pageable paginacao);
    Usuario findByCpf(String cpf);
}
