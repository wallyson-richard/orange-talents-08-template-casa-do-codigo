package br.com.zupacademy.wallyson.casadocodigo.controller;

import br.com.zupacademy.wallyson.casadocodigo.controller.requestdto.NovoClienteRequest;
import br.com.zupacademy.wallyson.casadocodigo.controller.responsedto.ClienteCriadoResponse;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Cliente;
import br.com.zupacademy.wallyson.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.wallyson.casadocodigo.repository.EstadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final EstadoRepository estadoRepository;

    public ClienteController(ClienteRepository clienteRepository, EstadoRepository estadoRepository) {
        this.clienteRepository = clienteRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid NovoClienteRequest request) {
        Cliente cliente = request.toModel(estadoRepository);
        cliente = clienteRepository.save(cliente);
        ClienteCriadoResponse id = new ClienteCriadoResponse(cliente);
        return ResponseEntity.ok(id);
    }
}
