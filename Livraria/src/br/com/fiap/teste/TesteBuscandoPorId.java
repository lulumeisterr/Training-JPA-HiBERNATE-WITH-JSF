package br.com.fiap.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.BO.AutorBO;
import br.com.fiap.BO.LivroBO;
import br.com.fiap.daoImpl.AutorDAOimpl;
import br.com.fiap.daoImpl.LivroDAOimpl;
import br.com.fiap.daoInterface.AutorDAO;
import br.com.fiap.daoInterface.LivroDAO;
import br.com.fiap.model.entity.Autor;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteBuscandoPorId {

	public static void main(String[] args) {

		EntityManagerFactory fa = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fa.createEntityManager();

		AutorDAO Ldao = new AutorDAOimpl(em);
		
		List<Autor> autor = Ldao.BuscarPorId(1);
		
		for (Autor a : autor) {
			System.out.println(a.getNome());
			System.out.println(a.getAutor());
		}
		

		em.close();
		fa.close();

	}

}

