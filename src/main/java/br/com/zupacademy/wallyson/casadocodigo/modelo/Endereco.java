package br.com.zupacademy.wallyson.casadocodigo.modelo;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Endereco {

    private String endereco;
    private String complemento;
    private String cep;
    private String cidade;
    @ManyToOne
    private Estado estado;
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Endereco() {
    }

    public Endereco(String endereco, String complemento, String cep, String cidade, Estado estado, Pais pais) {
        this.endereco = endereco;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
}
