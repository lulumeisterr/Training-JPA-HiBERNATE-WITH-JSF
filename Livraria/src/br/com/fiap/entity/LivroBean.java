package br.com.fiap.entity;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.BO.AutorBO;
import br.com.fiap.BO.LivroBO;
import br.com.fiap.model.entity.Autor;
import br.com.fiap.model.entity.Livro;

@ManagedBean
public class LivroBean {
	
	private Livro livro;
	private int idAutor;
	
	@PostConstruct
	public void init(){
		this.livro = new Livro();
		
	}
	

	public String cadastrar() throws Exception{
		
		System.out.println(" Cadastrando : " + this.livro);
		
		LivroBO Lbo = new LivroBO();
		Lbo.LivroCadastro(livro);
		
		if(livro.getAutores().isEmpty()){
			throw new Exception("Deve contar um autor");
		}
		
		//Para o formulario voltar ser null
		//this.livro = new Livro();
		
		return "Cadastrado.xhtml";
		
	}
	
	/*
	 * Retornando atraves de JPQL
	 */
	
	public List<Autor> getAutores(){
		LivroBO Lbo = new LivroBO();
		return Lbo.ListarTodos();
	}

	/*
	 * Criando o metodo apenas para associar-se com o livro
	 */
	
	public void gravar(){

		LivroBO bo = new LivroBO();
		bo.ListarPorId(this.idAutor);
		
		Autor a = new Autor();
		this.livro.adicionaAutor(a);
		
		System.out.println(idAutor + a.getNome());
		
	}

	
	public Livro getLivro() {
		return livro;
	}



	public void setLivro(Livro livro) {
		this.livro = livro;
	}



	public int getIdAutor() {
		return idAutor;
	}



	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	
}