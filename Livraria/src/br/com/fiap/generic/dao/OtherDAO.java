package br.com.fiap.generic.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.excecao.DBException;
import br.com.fiap.excecao.IdNotFoundException;

public class OtherDAO <Table>{
	
	private EntityManager em;
	
	private final Class<Table> classe;
	
	public OtherDAO(Class<Table> classe) {
		this.classe = classe;
	}
	

	public void Cadastrar(Table t) {
		
		em.getTransaction().begin();
		
		em.persist(t);
		
		em.getTransaction().commit();
		
		em.close();
		
	}



	
}
