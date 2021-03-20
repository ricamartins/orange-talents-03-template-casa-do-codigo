package br.com.zupacademy.ricardo.casadocodigo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tb_livros")
public class Livro {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String titulo;
	
	@NotEmpty @Length(max=500)
	private String resumo;
	
	private String sumario;
	
	@NotNull @Min(20)
	private Double preco;
	
	@NotNull @Min(100)
	private Integer paginas;

	@NotEmpty
	private String isbn;
	
	@NotNull @Future @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataLancamento;

	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;

	@Deprecated
	public Livro() {}

	public Livro(Long id) {this.id = id;}

	public Livro(@NotEmpty String titulo, @NotEmpty @Length(max = 500) String resumo, String sumario,
			@NotNull @Min(20) Double preco, @NotNull @Min(100) Integer paginas, @NotEmpty String isbn,
			@NotNull @Future LocalDate dataLancamento, @NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
		this.autor = autor;
	}
	
}
