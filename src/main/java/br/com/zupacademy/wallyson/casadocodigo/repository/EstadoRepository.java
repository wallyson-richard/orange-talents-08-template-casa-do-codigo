package br.com.zupacademy.wallyson.casadocodigo.repository;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Estado;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findByNomeAndPais(String nome, Pais pais);
}
