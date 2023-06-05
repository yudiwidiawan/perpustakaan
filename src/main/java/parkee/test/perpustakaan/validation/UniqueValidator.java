package parkee.test.perpustakaan.validation;

import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueValidator implements ConstraintValidator<UniqueField, Object> {

    @PersistenceContext
    private EntityManager entityManager;
    Class<?> entity;
    String name;

    @Override
    public void initialize(UniqueField constraint) {
        this.name = constraint.name();
        this.entity = constraint.entity();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean isValid = true;
        context.disableDefaultConstraintViolation();
        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<?> cq = builder.createQuery(entity);
        Root<?> table = cq.from(entity);
        Predicate predicateEqual = builder.equal(table.get(name), value);
        cq.where(predicateEqual);
        TypedQuery<?> query = entityManager.createQuery(cq);
        if (query.getResultList().size() > 0) {
            context
                    .buildConstraintViolationWithTemplate( value + " already exist!" )
                    .addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }
    
}
