package br.com.zupacademy.wallyson.casadocodigo.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nome;
    @Column(columnDefinition = "varchar(400)")
    private String descricao;
    private LocalDateTime dataCriacao =  LocalDateTime.now();

    public Autor(){
    }

    public Autor(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }
}
