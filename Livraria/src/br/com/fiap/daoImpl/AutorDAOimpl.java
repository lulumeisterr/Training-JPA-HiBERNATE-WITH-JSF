package br.com.fiap.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.daoInterface.AutorDAO;
import br.com.fiap.generic.dao.GenericDAOimpl;
import br.com.fiap.model.entity.Autor;

public class AutorDAOimpl extends GenericDAOimpl<Autor, Integer> implements AutorDAO{

	public AutorDAOimpl(EntityManager em) {
		super(em);
	
	}


	@Override
	public List<Autor> listarAutores() {
		return em.createQuery("from Autor" , Autor.class)
				.getResultList();

	}

	@Override
	public List<Autor> BuscarPorId(int id) {
		return em.createQuery("from Autor a where a.autor = :n", Autor.class)
				.setParameter("n", id).getResultList();
	}



}
