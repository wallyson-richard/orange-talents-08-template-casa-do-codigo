package br.com.zupacademy.wallyson.casadocodigo.controller;

import br.com.zupacademy.wallyson.casadocodigo.controller.requestdto.NovoAutorRequest;
import br.com.zupacademy.wallyson.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid NovoAutorRequest novoAutor) {
        autorRepository.save(novoAutor.toModel());
        return ResponseEntity.ok().build();
    }
}
