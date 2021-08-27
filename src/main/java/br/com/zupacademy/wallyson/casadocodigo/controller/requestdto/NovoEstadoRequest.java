package br.com.zupacademy.wallyson.casadocodigo.controller.requestdto;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Estado;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Pais;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Exists;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Exists
    private Pais pais;

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado toModel() {
        return new Estado(nome, pais);
    }
}
