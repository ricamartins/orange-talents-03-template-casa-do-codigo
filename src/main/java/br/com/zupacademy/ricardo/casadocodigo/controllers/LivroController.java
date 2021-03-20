package br.com.zupacademy.ricardo.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ricardo.casadocodigo.controllers.forms.LivroForm;
import br.com.zupacademy.ricardo.casadocodigo.repositories.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	private LivroRepository repository;

	public LivroController(LivroRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm livroForm) {
		repository.save(livroForm.converter());
		return ResponseEntity.ok().build();
	}
	
}
