package br.com.zupacademy.wallyson.casadocodigo.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<BadRequestDto> erros = new ArrayList<>();
        for (FieldError field : ex.getFieldErrors()) {
            erros.add(new BadRequestDto(field.getField(), field.getDefaultMessage()));
        }
        return ResponseEntity.badRequest().body(erros);
    }
}
