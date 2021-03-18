package br.com.zupacademy.ricardo.casadocodigo.controllers.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.ricardo.casadocodigo.models.Autor;

public class AutorForm {

	@NotEmpty
	private String nome;
	
	@NotEmpty @Email
	private String email;
	
	@NotEmpty @Length(max=400)
	private String descricao;
	
	public AutorForm(@NotEmpty String nome, @NotEmpty @Email String email,
			@NotEmpty @Length(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor converter() {
		return new Autor(nome, email, descricao);
	}
}
