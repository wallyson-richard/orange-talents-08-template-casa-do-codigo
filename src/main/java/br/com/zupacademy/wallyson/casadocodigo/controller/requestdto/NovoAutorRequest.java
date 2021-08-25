package br.com.zupacademy.wallyson.casadocodigo.controller.requestdto;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Autor;
import br.com.zupacademy.wallyson.casadocodigo.modelo.enums.RegistroUnico;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Unico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotBlank
    @Email
    @Unico(RegistroUnico.AUTOR)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converter() {
        return new Autor(this.email, this.nome, this.descricao);
    }
}
