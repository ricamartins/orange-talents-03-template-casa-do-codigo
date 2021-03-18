package br.com.zupacademy.ricardo.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ricardo.casadocodigo.controllers.forms.AutorForm;
import br.com.zupacademy.ricardo.casadocodigo.repositories.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private final AutorRepository repository;

	public AutorController(AutorRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorForm autorForm) {
		repository.save(autorForm.converter());
		return ResponseEntity.ok().build();
	}
	
}
