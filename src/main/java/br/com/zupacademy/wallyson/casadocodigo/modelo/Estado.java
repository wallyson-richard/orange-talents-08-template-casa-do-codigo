package br.com.zupacademy.wallyson.casadocodigo.modelo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public Pais getPais() {
        return pais;
    }

    public static boolean listaContemOEstado(List<Estado> estados, Estado estado) {
        boolean estadoExisteNaListaDeEstados = false;
        for (Estado x : estados) {
            if (x.equals(estado)) {
                estadoExisteNaListaDeEstados = true;
                break;
            }
        }
        return estadoExisteNaListaDeEstados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
