package br.com.zupacademy.wallyson.casadocodigo.modelo;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nome;

    private String sobrenome;

    private String documento;

    @Embedded
    private Endereco endereco;

    @Deprecated
    public Cliente() {
    }

    public Cliente(String email, String nome, String sobrenome, String documento, Endereco endereco) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }
}
