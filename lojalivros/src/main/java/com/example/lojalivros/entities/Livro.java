package com.example.lojalivros.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Integer paginas;
	
	@Column(nullable = false)
	private Integer capitulos;
	
	@Column(name = "publisher_name",nullable = false)
	private String isbn;
	
	@Column(name = "nome_publicado",nullable = false, unique = true)
	private String nomePublicado;
	
	
	//um autor pode ter varios livros
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "autor_id")
	private Autor autor;


	public Livro() {
		super();
	}


	public Livro(Long id, String nome, Integer paginas, Integer capitulos, String isbn, String nomePublicado,
			Autor autor) {
		super();
		this.id = id;
		this.nome = nome;
		this.paginas = paginas;
		this.capitulos = capitulos;
		this.isbn = isbn;
		this.nomePublicado = nomePublicado;
		this.autor = autor;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getPaginas() {
		return paginas;
	}


	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}


	public Integer getCapitulos() {
		return capitulos;
	}


	public void setCapitulos(Integer capitulos) {
		this.capitulos = capitulos;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getNomePublicado() {
		return nomePublicado;
	}


	public void setNomePublicado(String nomePublicado) {
		this.nomePublicado = nomePublicado;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}
