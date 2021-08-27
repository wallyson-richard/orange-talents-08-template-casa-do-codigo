package br.com.zupacademy.wallyson.casadocodigo.validation.validators;

import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Exists;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.List;

public class ExistsValidator implements ConstraintValidator<Exists, Object> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(Exists constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (ObjectUtils.isEmpty(value)) {
            return false;
        }

        try {
            Class<?> classe = value.getClass();
            Field field = classe.getDeclaredField("id");
            field.setAccessible(true);
            Object id = field.get(value);
            Query query = entityManager.createQuery("select a from " + classe.getSimpleName() + " a where a." + field.getName() + " = :id");
            query.setParameter("id", id);
            List<?> resultList = query.getResultList();
            return !resultList.isEmpty();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException();
        }
    }
}