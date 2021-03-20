package br.com.zupacademy.ricardo.casadocodigo.controllers.forms;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.ricardo.casadocodigo.models.Autor;
import br.com.zupacademy.ricardo.casadocodigo.models.Categoria;
import br.com.zupacademy.ricardo.casadocodigo.models.Livro;
import br.com.zupacademy.ricardo.casadocodigo.validation.MustExist;
import br.com.zupacademy.ricardo.casadocodigo.validation.Unique;

public class LivroForm {

	@NotEmpty @Unique(klass=Livro.class, field="titulo")
	private String titulo;
	
	@NotEmpty @Length(max=500)
	private String resumo;
	
	private String sumario;
	
	@NotNull @Min(20)
	private Double preco;
	
	@NotNull @Min(100)
	private Integer paginas;

	@NotEmpty @ISBN @Unique(klass=Livro.class, field="isbn")
	private String isbn;
	
	@NotNull @Future @JsonFormat(pattern="yyyy/MM/dd")
	private LocalDate dataLancamento;

	@NotNull
	@MustExist(klass=Categoria.class)
	private Long categoriaId;
	
	@NotNull
	@MustExist(klass=Autor.class)
	private Long autorId;

	public LivroForm(@NotEmpty String titulo, @NotEmpty @Length(max = 500) String resumo, String sumario,
			@NotNull @Min(20) Double preco, @NotNull @Min(100) Integer paginas, @NotEmpty String isbn,
			@NotNull Long categoriaId, @NotNull Long autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Livro converter() {
		Categoria categoria = new Categoria(categoriaId);
		Autor autor = new Autor(autorId);
		return new Livro(titulo, resumo, sumario,
				preco, paginas, isbn, dataLancamento, categoria, autor);
	}
	
}