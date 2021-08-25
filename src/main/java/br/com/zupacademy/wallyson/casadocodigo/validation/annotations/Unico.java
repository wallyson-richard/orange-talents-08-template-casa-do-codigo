package br.com.zupacademy.wallyson.casadocodigo.validation.annotations;

import br.com.zupacademy.wallyson.casadocodigo.modelo.enums.RegistroUnico;
import br.com.zupacademy.wallyson.casadocodigo.validation.validators.UnicoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({FIELD, METHOD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UnicoValidator.class})
public @interface Unico {
    String message() default "O dado informado não é válido, pois já se encontra na nossa base de dados.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    RegistroUnico value();
}
