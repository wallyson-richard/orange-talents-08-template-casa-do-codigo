package br.com.zupacademy.wallyson.casadocodigo.controller;

import br.com.zupacademy.wallyson.casadocodigo.controller.requestdto.NovoLivroRequest;
import br.com.zupacademy.wallyson.casadocodigo.controller.responsedto.TodosLivrosResponse;
import br.com.zupacademy.wallyson.casadocodigo.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid NovoLivroRequest request) {
        livroRepository.save(request.toModel());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TodosLivrosResponse>> findAll() {
        List<TodosLivrosResponse> livros = livroRepository.findAll().stream().map(TodosLivrosResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(livros);
    }
}
