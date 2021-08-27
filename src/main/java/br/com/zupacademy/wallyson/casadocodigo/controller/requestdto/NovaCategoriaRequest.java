package br.com.zupacademy.wallyson.casadocodigo.controller.requestdto;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Categoria;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Unique;
import br.com.zupacademy.wallyson.casadocodigo.modelo.enums.RegistroUnico;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @Unique(RegistroUnico.CATEGORIA_NOME)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(this.getNome());
    }
}
