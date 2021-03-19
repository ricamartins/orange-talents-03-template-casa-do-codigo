package br.com.zupacademy.ricardo.casadocodigo.validation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

	@PersistenceContext
	private EntityManager manager;
	
	private String message;
	private Class<?> klass;
	private String field;
	
	@Override
	public void initialize(Unique annotation) {
		this.message = annotation.message();
		this.klass = annotation.klass();
		this.field = annotation.field();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			Query query = manager.createQuery("select e from "+klass.getSimpleName()+" e where e."+field+" = :value");
			query.setParameter("value", value);
			Object result = query.getSingleResult();
			return false;
		} catch (NoResultException e) {
			return true;
		}
	}

}
