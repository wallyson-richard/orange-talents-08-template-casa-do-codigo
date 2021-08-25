package br.com.zupacademy.wallyson.casadocodigo.modelo.enums;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Autor;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Categoria;

public enum RegistroUnico {
    AUTOR(Autor.class, "email"),
    CATEGORIA(Categoria.class, "nome");

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
