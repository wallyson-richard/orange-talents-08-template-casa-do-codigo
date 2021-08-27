package br.com.zupacademy.wallyson.casadocodigo.controller;

import br.com.zupacademy.wallyson.casadocodigo.controller.requestdto.NovoEstadoRequest;
import br.com.zupacademy.wallyson.casadocodigo.exceptionhandler.BadRequestDto;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Estado;
import br.com.zupacademy.wallyson.casadocodigo.repository.EstadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoRepository estadoRepository;

    public EstadoController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid NovoEstadoRequest novoEstado) {
        List<Estado> estados = estadoRepository.findByNomeAndPais(novoEstado.getNome(), novoEstado.getPais());
        Estado estado = novoEstado.toModel();
        boolean estadoJaExiste = !estados.isEmpty();

        if (estadoJaExiste) {
            var dto = new BadRequestDto("pais", "Já existe um estado com esse nome, cadastrado para esse país!");
            return ResponseEntity.badRequest().body(dto);
        }

        estadoRepository.save(estado);
        return ResponseEntity.ok().build();

    }
}
