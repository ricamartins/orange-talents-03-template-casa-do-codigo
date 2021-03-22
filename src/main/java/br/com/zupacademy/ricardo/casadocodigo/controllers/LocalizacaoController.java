package br.com.zupacademy.ricardo.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ricardo.casadocodigo.controllers.forms.EstadoForm;
import br.com.zupacademy.ricardo.casadocodigo.controllers.forms.PaisForm;
import br.com.zupacademy.ricardo.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.ricardo.casadocodigo.repositories.PaisRepository;

@RestController
public class LocalizacaoController {

	private PaisRepository paisRepository;
	private EstadoRepository estadoRepository;
		
	public LocalizacaoController(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		this.paisRepository = paisRepository;
		this.estadoRepository = estadoRepository;
	}

	@PostMapping("/paises")
	public ResponseEntity<?> cadastraPais(@RequestBody @Valid PaisForm paisForm) {
		paisRepository.save(paisForm.converter());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/estados")
	public ResponseEntity<?> cadastraEstado(@RequestBody @Valid EstadoForm estadoForm) {
		estadoRepository.save(estadoForm.converter());
		return ResponseEntity.ok().build();
	}
}
