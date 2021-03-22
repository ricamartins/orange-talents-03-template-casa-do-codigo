package br.com.zupacademy.ricardo.casadocodigo.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class NotNullIfHasOptionsValidator implements ConstraintValidator<NotNullIfHasOptions, Object> {

	@PersistenceContext
	private EntityManager manager;
	
	private String message;
	private Class<?> entity;
	private String primaryEntity;
	
	@Override
	public void initialize(NotNullIfHasOptions annotation) {
		this.message = annotation.message();
		this.entity = annotation.notNull();
		this.primaryEntity = annotation.options();
	}
	
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		
		Query query = manager.createQuery("select e from "+entity.getSimpleName()+" e where e."+primaryEntity+".id = :id");
		query.setParameter("id", callGetterFor(primaryEntity+"Id", object));
		List results = query.getResultList();
	
		if (results.isEmpty()) return true;
		
		
		Object notNullAttribute = callGetterFor(entity.getSimpleName().toLowerCase()+"Id", object);
		if (notNullAttribute == null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
				.addPropertyNode(entity.getSimpleName().toLowerCase()+"Id")
				.addConstraintViolation();
			return false;
		}
		
		try {
			Query queryMustExist = manager.createQuery("select e from "+entity.getSimpleName()+" e where id = :id");
			queryMustExist.setParameter("id", notNullAttribute);
			queryMustExist.getSingleResult();
			return true;
		} catch (NoResultException e) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Deve estar cadastrado")
				.addPropertyNode(entity.getSimpleName().toLowerCase()+"Id")
				.addConstraintViolation();
			return false;
		}
		
		//Não faz a verificação se aquele estado é daquele país específico
		
	}

	private Object callGetterFor(String column, Object object) {

		String methodName = "get" + StringUtils.capitalize(column);
		try {
			Method method = object.getClass().getMethod(methodName);
			return method.invoke(object);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return null;
		}

	}
}
