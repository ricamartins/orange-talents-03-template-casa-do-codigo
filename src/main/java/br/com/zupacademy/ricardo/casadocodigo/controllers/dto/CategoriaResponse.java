package br.com.zupacademy.ricardo.casadocodigo.controllers.dto;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.zupacademy.ricardo.casadocodigo.models.Categoria;

public class CategoriaResponse {

	private Long id;
	
	@JsonView({View.LivroView.Detalhes.class})
	private String nome;
	
	public CategoriaResponse(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

}
