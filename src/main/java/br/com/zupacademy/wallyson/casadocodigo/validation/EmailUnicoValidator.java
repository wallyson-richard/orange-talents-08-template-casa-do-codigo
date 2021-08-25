package br.com.zupacademy.wallyson.casadocodigo.validation;

import br.com.zupacademy.wallyson.casadocodigo.modelo.Autor;
import br.com.zupacademy.wallyson.casadocodigo.repository.AutorRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

    private AutorRepository autorRepository;

    public EmailUnicoValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public void initialize(EmailUnico constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Autor> autor = autorRepository.findByEmail(value);
        return autor.isEmpty();
    }
}
