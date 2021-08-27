package br.com.zupacademy.wallyson.casadocodigo.controller.responsedto;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Livro;

public class TodosLivrosResponse {

    private Long id;
    private String nome;

    public TodosLivrosResponse(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
