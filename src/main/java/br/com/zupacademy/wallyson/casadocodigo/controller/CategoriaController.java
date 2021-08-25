package br.com.zupacademy.wallyson.casadocodigo.controller;

import br.com.zupacademy.wallyson.casadocodigo.controller.requestdto.NovaCategoriaRequest;
import br.com.zupacademy.wallyson.casadocodigo.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid NovaCategoriaRequest novaCategoria) {
        categoriaRepository.save(novaCategoria.converter());
        return ResponseEntity.ok().build();
    }
}
