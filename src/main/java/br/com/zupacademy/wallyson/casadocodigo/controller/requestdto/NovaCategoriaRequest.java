package br.com.zupacademy.wallyson.casadocodigo.controller.requestdto;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Categoria;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Unico;
import br.com.zupacademy.wallyson.casadocodigo.modelo.enums.RegistroUnico;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @Unico(RegistroUnico.CATEGORIA)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        return new Categoria(this.getNome());
    }
}
