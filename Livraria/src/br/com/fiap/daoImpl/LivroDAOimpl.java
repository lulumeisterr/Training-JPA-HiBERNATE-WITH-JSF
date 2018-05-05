package br.com.fiap.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.daoInterface.LivroDAO;
import br.com.fiap.generic.dao.GenericDAOimpl;
import br.com.fiap.model.entity.Autor;
import br.com.fiap.model.entity.Livro;

public class LivroDAOimpl extends GenericDAOimpl<Livro, Integer> implements LivroDAO{

	public LivroDAOimpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	
	
}
