package br.com.zupacademy.wallyson.casadocodigo.repository;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
}
