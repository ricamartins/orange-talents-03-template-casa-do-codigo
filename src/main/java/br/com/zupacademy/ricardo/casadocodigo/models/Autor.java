package br.com.zupacademy.ricardo.casadocodigo.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="tb_autores")
public class Autor {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty @Email
	@Column(unique=true)
	private String email;
	
	@NotEmpty @Length(max=400)
	private String descricao;
	
	private LocalDateTime dataRegistro = LocalDateTime.now();
	
	@Deprecated
	public Autor() {}
	
	public Autor(Long id) {this.id = id;}

	public Autor(@NotEmpty String nome, @NotEmpty @Email String email, @NotEmpty @Length(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
}
