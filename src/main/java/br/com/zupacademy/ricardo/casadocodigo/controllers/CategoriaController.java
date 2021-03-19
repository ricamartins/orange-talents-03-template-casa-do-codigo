package br.com.zupacademy.ricardo.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ricardo.casadocodigo.controllers.forms.CategoriaForm;
import br.com.zupacademy.ricardo.casadocodigo.repositories.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private CategoriaRepository repository;

	public CategoriaController(CategoriaRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm) {
		repository.save(categoriaForm.converter());
		return ResponseEntity.ok().build();
	}
}
