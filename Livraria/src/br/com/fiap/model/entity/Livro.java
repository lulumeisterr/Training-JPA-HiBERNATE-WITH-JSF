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

import org.hibernate.engine.internal.Cascade;


@Entity
@Table(name = "T_AULA_LIVRO")
@SequenceGenerator(sequenceName = "T_SQ_AULA_LIVRO" , allocationSize = 1  , name = "livro")

public class Livro implements Serializable{

	private static final long serialVersionUID = -8808408342957467965L;

	@Id
	@GeneratedValue(generator = "livro" , strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_livro")
	private int codigo;
	
	@Column(name = "nm_titulo")
	public String titulo;
	
	@Column(name = "ds_isbn")
	public String isbn;
	
	@Column(name = "vl_preco")
	public double preco;
	
	@Column(name = "dt_lancamento")
	public String data;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "T_AULA_LIVRO_AUTOR" , joinColumns = @JoinColumn(name = "cd_livro") , 
	inverseJoinColumns = @JoinColumn(name = "cd_autor"))
	private List<Autor> autores;

	public Livro() {
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}




	public Livro(String titulo, String isbn, double preco, String data) {
		super();
		

		this.titulo = titulo;
		this.isbn = isbn;
		this.preco = preco;
		this.data = data;
	
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	
	
}