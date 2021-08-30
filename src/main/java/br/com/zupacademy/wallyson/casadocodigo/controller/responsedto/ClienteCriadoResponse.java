package br.com.zupacademy.wallyson.casadocodigo.controller.responsedto;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Cliente;

public class ClienteCriadoResponse {

    private Long id;

    public ClienteCriadoResponse(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
