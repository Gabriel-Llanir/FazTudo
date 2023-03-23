package br.com.fiap.appservico.Repositories;

import br.com.fiap.appservico.Get.DadosLoginPrestador;
import br.com.fiap.appservico.Model.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {
    Optional<DadosLoginPrestador> findByCpfAndSenha(String cpf, String senha);
}
