package br.com.zupacademy.wallyson.casadocodigo.modelo;

import br.com.zupacademy.wallyson.casadocodigo.modelo.enums.RegistroUnico;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Unique;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Deprecated
    public Categoria() {
    }

    public Categoria(@NotBlank @Unique(RegistroUnico.CATEGORIA_NOME)String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

}
