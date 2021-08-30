package br.com.zupacademy.wallyson.casadocodigo.modelo.enums;

import br.com.zupacademy.wallyson.casadocodigo.modelo.*;

public enum RegistroUnico {
    AUTOR_EMAIL(Autor.class, "email"),
    CATEGORIA_NOME(Categoria.class, "nome"),
    LIVRO_TITULO(Livro .class, "titulo"),
    LIVRO_ISBN(Livro.class, "isbn"),
    PAIS_NOME(Pais.class, "nome"),
    CLIENTE_EMAIL(Cliente.class, "email"),
    CLIENTE_DOCUMENTO(Cliente.class, "documento");

    private final Class<?> classe;
    private final String atributo;

    RegistroUnico(Class<?> classe, String atributo) {
        this.classe = classe;
        this.atributo = atributo;
    }

    public Class<?> getClasse() {
        return classe;
    }

    public String getAtributo() {
        return atributo;
    }
}
