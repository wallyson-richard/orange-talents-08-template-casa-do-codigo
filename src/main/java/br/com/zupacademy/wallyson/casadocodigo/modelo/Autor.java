package br.com.zupacademy.wallyson.casadocodigo.modelo;

import br.com.zupacademy.wallyson.casadocodigo.modelo.enums.RegistroUnico;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Unique;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    public Autor(@NotBlank @Email @Unique(RegistroUnico.AUTOR_EMAIL) String email, @NotBlank String nome, @NotBlank
    @Size(max = 400) String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
