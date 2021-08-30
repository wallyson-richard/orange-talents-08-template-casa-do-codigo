package br.com.zupacademy.wallyson.casadocodigo.controller.exceptions;

import org.springframework.validation.FieldError;

import java.util.List;

public class ArgumentsNotValidException extends RuntimeException {

    private final List<FieldError> fieldErrors;

    public ArgumentsNotValidException(List<FieldError> erros) {
        this.fieldErrors = erros;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
