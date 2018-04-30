package br.com.fiap.entity;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.BO.AutorBO;
import br.com.fiap.daoImpl.AutorDAOimpl;
import br.com.fiap.daoInterface.AutorDAO;
import br.com.fiap.model.entity.Autor;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
public class AutorBean {

	private Autor autor;
	
	/*
	 * postConstruct sinaliza que o método anotado tem que roda primeiro que todo o resto
	 * 
	 */
	
	@PostConstruct
	public void init(){
		this.autor = new Autor();
	}
	

	public String cadastrar()throws Exception{
		
			AutorBO bo = new AutorBO();
			bo.AutorCadastro(autor);
	
		return "livro.xhtml";
	}
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
}


