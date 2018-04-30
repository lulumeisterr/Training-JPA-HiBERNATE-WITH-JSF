package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.daoInterface.AutorDAO;
import br.com.fiap.generic.dao.GenericDAOimpl;
import br.com.fiap.model.entity.Autor;

public class AutorDAOimpl extends GenericDAOimpl<Autor, Integer> implements AutorDAO{

	public AutorDAOimpl(EntityManager em) {
		super(em);
	
	}



}
