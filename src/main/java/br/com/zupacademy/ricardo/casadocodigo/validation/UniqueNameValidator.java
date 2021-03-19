package br.com.zupacademy.ricardo.casadocodigo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.ricardo.casadocodigo.repositories.CategoriaRepository;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public void initialize(UniqueName constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(String nome, ConstraintValidatorContext context) {
		return !repository.findByNome(nome).isPresent();
	}

}
