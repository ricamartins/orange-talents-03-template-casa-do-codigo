package br.com.zupacademy.ricardo.casadocodigo.controllers.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.zupacademy.ricardo.casadocodigo.models.Livro;

public class LivroResponse {

	@JsonView({View.LivroView.Minimo.class})
	private Long id;
	
	@JsonView({View.LivroView.Minimo.class})
	private String titulo;
	
	private String resumo;
	
	private String sumario;
	
	private Double preco;
	
	private Integer paginas;

	private String isbn;
	
	private LocalDate dataLancamento;

	private CategoriaResponse categoria;
	
	private AutorResponse autor;

	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataLancamento = livro.getDataLancamento();
		this.categoria = new CategoriaResponse(livro.getCategoria());
		this.autor = new AutorResponse(livro.getAutor());
	}

	public static List<LivroResponse> converter(List<Livro> livros) {
		return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
	}

	public static LivroResponse converter(Livro livro) {
		return new LivroResponse(livro);
	}

}
