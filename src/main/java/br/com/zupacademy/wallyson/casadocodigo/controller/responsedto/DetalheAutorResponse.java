package br.com.zupacademy.wallyson.casadocodigo.controller.responsedto;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Autor;

public class DetalheAutorResponse {

    private String nome;
    private String descricao;

    public DetalheAutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
