package br.com.zupacademy.ricardo.casadocodigo.controllers.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.ricardo.casadocodigo.models.Estado;
import br.com.zupacademy.ricardo.casadocodigo.models.Pais;
import br.com.zupacademy.ricardo.casadocodigo.validation.Unique;

@Unique(fields={"nome,pais"})
public class EstadoForm {

	@NotEmpty
	private String nome;

	@NotNull
	private Long paisId;

	public EstadoForm(@NotEmpty String nome, @NotNull Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public String getNome() {
		return nome;
	}
	
	public Long getPaisId() {
		return paisId;
	}
	
	public Estado converter() {
		Pais pais = new Pais(paisId);
		return new Estado(nome, pais);
	}	
	
}
