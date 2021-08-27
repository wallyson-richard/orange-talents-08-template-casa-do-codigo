package br.com.zupacademy.wallyson.casadocodigo.controller.requestdto;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Autor;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Categoria;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Livro;
import br.com.zupacademy.wallyson.casadocodigo.modelo.enums.RegistroUnico;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Exists;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Unique;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @Unique(RegistroUnico.LIVRO_TITULO)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @Min(20)
    private BigDecimal preco;

    @Min(100)
    private Integer paginas;

    @NotBlank
    @Unique(RegistroUnico.LIVRO_ISBN)
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @Exists
    private Autor autor;

    @NotNull
    @Exists
    private Categoria categoria;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Livro toModel() {
        return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, autor, categoria);
    }
}
