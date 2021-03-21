package br.com.zupacademy.ricardo.casadocodigo.controllers.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.zupacademy.ricardo.casadocodigo.models.Autor;

public class AutorResponse {

	private Long id;
	
	@JsonView({View.LivroView.Detalhes.class})
	private String nome;
	
	private String email;
	
	@JsonView({View.LivroView.Detalhes.class})
	private String descricao;
	
	private LocalDateTime dataRegistro;
	
	public AutorResponse(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.dataRegistro = autor.getDataRegistro();
	}

}
