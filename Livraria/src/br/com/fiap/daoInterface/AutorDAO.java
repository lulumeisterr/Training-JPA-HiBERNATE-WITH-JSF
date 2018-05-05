package br.com.fiap.daoInterface;

import java.util.List;

import br.com.fiap.generic.dao.GenericDAO;
import br.com.fiap.model.entity.Autor;

public interface AutorDAO extends GenericDAO<Autor,  Integer>{

	List<Autor> listarAutores ();
	List<Autor> BuscarPorId(int id);

	
}
