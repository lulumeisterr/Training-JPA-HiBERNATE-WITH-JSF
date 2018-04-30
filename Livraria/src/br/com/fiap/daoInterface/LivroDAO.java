package br.com.fiap.daoInterface;

import java.util.List;

import br.com.fiap.generic.dao.GenericDAO;
import br.com.fiap.model.entity.Autor;
import br.com.fiap.model.entity.Livro;

public interface LivroDAO extends GenericDAO<Livro, Integer>{
	
	List<Autor> listarAutores ();
	List<Autor> BuscarPorId(int id);
	
}
