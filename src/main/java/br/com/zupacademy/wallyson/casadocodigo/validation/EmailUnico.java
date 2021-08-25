package br.com.zupacademy.wallyson.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({FIELD, METHOD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailUnicoValidator.class})
public @interface EmailUnico {

    String message() default "O email informado já está em uso";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
