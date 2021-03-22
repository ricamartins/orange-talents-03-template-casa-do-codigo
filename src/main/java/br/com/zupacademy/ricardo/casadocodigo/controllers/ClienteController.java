package br.com.zupacademy.ricardo.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ricardo.casadocodigo.controllers.forms.ClienteForm;
import br.com.zupacademy.ricardo.casadocodigo.models.Cliente;
import br.com.zupacademy.ricardo.casadocodigo.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository repository;

	public ClienteController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<Long> cadastrar(@RequestBody @Valid ClienteForm clienteForm) {
		Cliente cliente = repository.save(clienteForm.converter());
		return ResponseEntity.ok(cliente.getId());
	}
}
