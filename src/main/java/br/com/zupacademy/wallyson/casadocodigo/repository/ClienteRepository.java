package br.com.zupacademy.wallyson.casadocodigo.repository;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
