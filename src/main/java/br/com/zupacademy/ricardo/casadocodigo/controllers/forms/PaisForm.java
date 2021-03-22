package br.com.zupacademy.ricardo.casadocodigo.controllers.forms;

import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.ricardo.casadocodigo.models.Pais;
import br.com.zupacademy.ricardo.casadocodigo.validation.Unique;

@Unique(fields={"nome"})
public class PaisForm {

	@NotEmpty
	private String nome;

	@Deprecated
	public PaisForm() {}
	
	public PaisForm(@NotEmpty String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Pais converter() {
		return new Pais(nome);
	}
	
}
