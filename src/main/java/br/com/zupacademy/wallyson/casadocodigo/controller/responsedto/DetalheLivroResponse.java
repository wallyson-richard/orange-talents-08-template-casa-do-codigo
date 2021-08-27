package br.com.zupacademy.wallyson.casadocodigo.controller.responsedto;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Autor;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalheLivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private DetalheAutorResponse autor;

    public DetalheLivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = new DetalheAutorResponse(livro.getAutor());
    }

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

    public DetalheAutorResponse getAutor() {
        return autor;
    }
}
