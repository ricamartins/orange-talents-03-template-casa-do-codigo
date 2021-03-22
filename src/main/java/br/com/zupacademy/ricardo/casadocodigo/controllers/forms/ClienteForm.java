package br.com.zupacademy.ricardo.casadocodigo.controllers.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.ricardo.casadocodigo.models.Cliente;
import br.com.zupacademy.ricardo.casadocodigo.models.Estado;
import br.com.zupacademy.ricardo.casadocodigo.models.Pais;
import br.com.zupacademy.ricardo.casadocodigo.validation.CPForCNPJ;
import br.com.zupacademy.ricardo.casadocodigo.validation.MustExist;
import br.com.zupacademy.ricardo.casadocodigo.validation.NotNullIfHasOptions;
import br.com.zupacademy.ricardo.casadocodigo.validation.Unique;

@NotNullIfHasOptions(notNull=Estado.class, options="pais")
@Unique(fields={"email", "documento"})
public class ClienteForm {

	@NotEmpty @Email
	private String email;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String sobrenome;
	
	@NotEmpty @CPForCNPJ
	private String documento;
	
	@NotEmpty
	private String endereco;
	
	@NotEmpty
	private String complemento;
	
	@NotEmpty
	private String cidade;
	
	@NotNull @MustExist(klass=Pais.class)
	private Long paisId;
	
	private Long estadoId;
	
	@NotEmpty
	private String telefone;
	
	@NotEmpty
	private String cep;
	
	public ClienteForm(@NotEmpty @Email String email, @NotEmpty String nome, @NotEmpty String sobrenome,
			@NotEmpty String documento, @NotEmpty String endereco, @NotEmpty String complemento,
			@NotEmpty String cidade, Long paisId, Long estadoId, @NotEmpty String telefone, @NotEmpty String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}

	//Para a validação de @Unique
	public String getEmail() {
		return email;
	}
	
	//Para a validação de @Unique
	public String getDocumento() {
		return documento;
	}
	
	//Para a validação de @NotNullIfHasOptions
	public Long getPaisId() {
		return paisId;
	}
	
	//Para a validação de @NotNullIfHasOptions
	public Long getEstadoId() {
		return estadoId;
	}
	
	public Cliente converter() {
		Pais pais = new Pais(paisId);
		Estado estado = (estadoId != null) ? new Estado(estadoId) : null;
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone, cep);
	}
}
