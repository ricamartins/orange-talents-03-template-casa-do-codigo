package br.com.zupacademy.ricardo.casadocodigo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.ricardo.casadocodigo.repositories.AutorRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private AutorRepository repository;

	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return !repository.findByEmail(email.toLowerCase()).isPresent();
	}

}
