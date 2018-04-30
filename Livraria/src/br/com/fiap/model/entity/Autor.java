package br.com.fiap.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_AULA_AUTOR")
@SequenceGenerator(name = "autor" ,  allocationSize = 1 , sequenceName = "SQ_T_AULA_AUTOR")
public class Autor implements Serializable{

	private static final long serialVersionUID = 2130760703925993573L;
	
	@Id
	@GeneratedValue(generator = "autor" , strategy = GenerationType.SEQUENCE)
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



	public Autor(String nome) {
		super();
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
