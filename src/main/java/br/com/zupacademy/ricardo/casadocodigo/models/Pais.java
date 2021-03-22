package br.com.zupacademy.ricardo.casadocodigo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_paises")
public class Pais {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@NotEmpty
	private String nome;

	@Deprecated
	public Pais() {}
	
	public Pais(@NotEmpty String nome) {
		this.nome = nome;
	}

	public Pais(@NotNull Long id) {
		this.id = id;
	}
	
}
