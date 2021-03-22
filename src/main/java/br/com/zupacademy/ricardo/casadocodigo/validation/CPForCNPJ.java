package br.com.zupacademy.ricardo.casadocodigo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Documented
@Constraint(validatedBy = { })
@ConstraintComposition(CompositionType.OR)
@CPF
@CNPJ
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPForCNPJ {

	String message() default "CPF ou CNPJ inválido";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
