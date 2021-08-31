package br.com.zupacademy.wallyson.casadocodigo.controller.requestdto;

import br.com.zupacademy.wallyson.casadocodigo.controller.exceptions.ArgumentsNotValidException;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Cliente;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Endereco;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Estado;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Pais;
import br.com.zupacademy.wallyson.casadocodigo.modelo.enums.RegistroUnico;
import br.com.zupacademy.wallyson.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.CpfOrCnpj;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Exists;
import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Unique;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class NovoClienteRequest {

    @Email
    @NotBlank
    @Unique(RegistroUnico.CLIENTE_EMAIL)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfOrCnpj
    @Unique(RegistroUnico.CLIENTE_DOCUMENTO)
    private String documento;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cep;

    @NotBlank
    private String cidade;

    @Exists(optional = true)
    private Estado estado;

    @NotNull
    @Exists
    private Pais pais;

    @NotBlank
    private String telefone;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public Pais getPais() {
        return pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cliente toModel(EstadoRepository estadoRepository) {
        List<Estado> estados = estadoRepository.findByPais(pais);
        boolean estadoPertenceAoPais = Estado.listaContemOEstado(estados, estado);

        if (ObjectUtils.isEmpty(estado) && !estados.isEmpty()) {
            throw new ArgumentsNotValidException(List.of(new FieldError("estado",
                    "estado",
                    "Para esse país é necessário informar um estado")));
        }

        if (!estadoPertenceAoPais) {
            throw new ArgumentsNotValidException(List.of(new FieldError("estado",
                    "estado",
                    "Estado não pertence ao país informado.")));
        }

        Endereco endereco1 = new Endereco(logradouro, complemento, cep, cidade, estado, pais);
        return new Cliente(email, nome, sobrenome, documento, endereco1);
    }
}
