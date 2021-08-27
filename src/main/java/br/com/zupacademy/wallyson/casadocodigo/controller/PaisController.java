package br.com.zupacademy.wallyson.casadocodigo.controller;

import br.com.zupacademy.wallyson.casadocodigo.controller.requestdto.NovoPaisRequest;
import br.com.zupacademy.wallyson.casadocodigo.modelo.Pais;
import br.com.zupacademy.wallyson.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<Pais> save(@RequestBody @Valid NovoPaisRequest novoPais) {
        paisRepository.save(novoPais.toModel());
        return ResponseEntity.ok().build();
    }
}
