package br.com.fiap.appservico.Domain.Prestador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {
    Prestador findByCpf(String cpf);
}
