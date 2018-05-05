package br.com.fiap.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name = "T_AULA_AUTOR")
public class Autor implements Serializable{

	private static final long serialVersionUID = 2130760703925993573L;
	
	@Id
	private int autor;
	
	@Column(name = "nm_autor")
	private String nome;
	
	@ManyToMany(mappedBy = "autores")
	private List<Livro> livros;
	
	
	public Autor(){
		super();
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}


	public Autor(int autor, String nome) {
		super();
		this.autor = autor;
		this.nome = nome;

	}

	public int getAutor() {
		return autor;
	}
	public void setAutor(int autor) {
		this.autor = autor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	

}
