package br.com.zupacademy.ricardo.casadocodigo.controllers.dto;

import br.com.zupacademy.ricardo.casadocodigo.models.Categoria;

public class CategoriaResponse {

	private Long id;
	
	private String nome;
	
	public CategoriaResponse(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

}
