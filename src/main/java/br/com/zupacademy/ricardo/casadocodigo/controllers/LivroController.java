package br.com.zupacademy.ricardo.casadocodigo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.zupacademy.ricardo.casadocodigo.controllers.dto.LivroResponse;
import br.com.zupacademy.ricardo.casadocodigo.controllers.dto.View;
import br.com.zupacademy.ricardo.casadocodigo.controllers.forms.LivroForm;
import br.com.zupacademy.ricardo.casadocodigo.models.Livro;
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
	
	@GetMapping
	@JsonView({View.LivroView.Minimo.class})
	public ResponseEntity<List<LivroResponse>> buscarTodos() {
		List<Livro> livros = repository.findAll();
		return ResponseEntity.ok(LivroResponse.converter(livros));
	}
	
}
