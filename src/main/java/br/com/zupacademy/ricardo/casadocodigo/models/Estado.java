package br.com.zupacademy.ricardo.casadocodigo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_estados")
public class Estado {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@NotEmpty
	private String nome;
	
	@ManyToOne @NotNull
	private Pais pais;

	@Deprecated
	public Estado() {}
	
	public Estado(@NotEmpty String nome, @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}	
	
}
