package br.com.zupacademy.wallyson.casadocodigo.validation.annotations;

import br.com.zupacademy.wallyson.casadocodigo.validation.validators.ExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({FIELD, METHOD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ExistsValidator.class})
public @interface Exists {
    String message() default "Informe um valor que esteja em nosso banco.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean optional() default false;

}
