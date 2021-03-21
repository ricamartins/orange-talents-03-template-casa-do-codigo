package br.com.zupacademy.ricardo.casadocodigo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.ricardo.casadocodigo.validation.UniqueName;

@Entity
@Table(name="tb_categorias")
public class Categoria {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nome;

	@Deprecated
	public Categoria() {}

	public Categoria(Long id) {this.id = id;}
	
	public Categoria(@NotEmpty String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
