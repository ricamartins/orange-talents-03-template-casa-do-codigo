package br.com.zupacademy.ricardo.casadocodigo.controllers.forms;

import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.ricardo.casadocodigo.models.Categoria;
import br.com.zupacademy.ricardo.casadocodigo.validation.Unique;
import br.com.zupacademy.ricardo.casadocodigo.validation.UniqueName;

public class CategoriaForm {

	@NotEmpty @Unique(klass=Categoria.class, field="nome")
	private String nome;

	@Deprecated
	public CategoriaForm() {}

	public CategoriaForm(@NotEmpty String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria converter() {
		return new Categoria(nome);
	}
}
