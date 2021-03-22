package br.com.zupacademy.ricardo.casadocodigo.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

	@PersistenceContext
	private EntityManager manager;
	
	private String message;
	private Class<?> klass;
	private String field;
	private String fields[];
	
	@Override
	public void initialize(Unique annotation) {
		this.message = annotation.message();
		this.klass = annotation.klass();
		this.field = annotation.field();
		this.fields = annotation.fields();
	}
	
	//No momento está verificando apenas o primeiro campo da anotação de classe
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		
		if (klass.equals(Unique.class)) {
			boolean hasViolation = false;
			context.disableDefaultConstraintViolation();
			
			if (fields.length == 0) return false;
			
			for (String field : fields) {
			
				String entity = getEntity(object);
				String column = getColumn(field);
				String primaryEntity = getPrimaryEntity(field);
				
				Query query;
				if (primaryEntity.isEmpty()) {
					query = manager.createQuery("select e from "+entity+" e where e."+column+" = :value");
					query.setParameter("value", callGetterFor(column, object));
				} else {					
					query = manager.createQuery("select e from "+entity+" e where e."+column+" = :value and e."+primaryEntity+".id = :id");
					query.setParameter("value", callGetterFor(column, object));
					query.setParameter("id", callGetterFor(primaryEntity+"Id", object));
				}
				
				try {
					Object result = query.getSingleResult();
					context.buildConstraintViolationWithTemplate(message)
						.addPropertyNode(column)
						.addConstraintViolation();
					hasViolation = true;
				} catch (NoResultException e) {}
			
			}
			
			if (hasViolation)
				return false;
			else
				return true;
			
		} else {
			try {
				Query query = manager.createQuery("select e from "+klass.getSimpleName()+" e where e."+field+" = :value");
				query.setParameter("value", object);
				Object result = query.getSingleResult();
				return false;
			} catch (NoResultException e) {
				return true;
			}
		}
		
		
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

	private String getPrimaryEntity(String field) {
		String[] split = field.split(",");
		return (split.length == 2) ? split[1] : "";
	}

	private String getColumn(String field) {
		String[] split = field.split(",");
		return split[0];
	}

	private String getEntity(Object object) {
		return object.getClass().getSimpleName().replace("Form", "").replace("Request", "").replaceAll("DTO", "").trim();
	}

	

}
