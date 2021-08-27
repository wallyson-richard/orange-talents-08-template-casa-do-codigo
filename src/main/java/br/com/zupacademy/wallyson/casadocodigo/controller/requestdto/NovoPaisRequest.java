package br.com.zupacademy.wallyson.casadocodigo.controller.requestdto;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Pais;
import br.com.zupacademy.wallyson.casadocodigo.modelo.enums.RegistroUnico;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Unique;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @Unique(RegistroUnico.PAIS_NOME)
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }
}
