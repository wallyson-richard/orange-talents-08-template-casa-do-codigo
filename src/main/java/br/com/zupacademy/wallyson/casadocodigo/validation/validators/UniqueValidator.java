package br.com.zupacademy.wallyson.casadocodigo.validation.validators;

import br.com.zupacademy.wallyson.casadocodigo.validation.annotations.Unique;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @PersistenceContext
    EntityManager entityManager;

    private String classe;
    private String atributo;

    @Override
    public void initialize(Unique constraintAnnotation) {
        classe = constraintAnnotation.value().getClasse().getSimpleName();
        atributo = constraintAnnotation.value().getAtributo();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select a from " + classe + " a where a." + atributo + " = :value");
        query.setParameter("value", value);
        List<?> resultList = query.getResultList();
        return resultList.isEmpty();
    }
}
