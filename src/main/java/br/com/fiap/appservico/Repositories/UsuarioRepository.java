package br.com.fiap.appservico.Repositories;

import br.com.fiap.appservico.Get.DadosLoginUsuario;
import br.com.fiap.appservico.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<DadosLoginUsuario> findByCpfAndSenha(String cpf, String senha);
}
