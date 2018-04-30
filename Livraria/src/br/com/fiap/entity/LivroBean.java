package br.com.fiap.entity;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.BO.LivroBO;
import br.com.fiap.model.entity.Autor;
import br.com.fiap.model.entity.Livro;

@ManagedBean
public class LivroBean {
	
	private Livro livro;
	
	@PostConstruct
	public void init(){
		this.livro = new Livro();
		
	}

	public String cadastrar() throws Exception{
		
		System.out.println(" Cadastrando : " + this.livro);
		
		LivroBO Lbo = new LivroBO();
		Lbo.LivroCadastro(livro);
		
		if(livro.getAutores().isEmpty()){
			return "erro.xhtml";
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
	

	
	public Livro getLivro() {
		return livro;
	}



	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
}