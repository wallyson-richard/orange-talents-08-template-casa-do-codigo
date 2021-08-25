package br.com.zupacademy.wallyson.casadocodigo.repository;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
