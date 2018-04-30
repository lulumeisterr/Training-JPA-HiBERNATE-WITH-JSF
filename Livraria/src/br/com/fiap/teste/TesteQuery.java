package br.com.fiap.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.daoImpl.LivroDAOimpl;
import br.com.fiap.daoInterface.LivroDAO;
import br.com.fiap.model.entity.Autor;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteQuery {

	public static void main(String[] args) {

		EntityManagerFactory fa = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fa.createEntityManager();

		LivroDAO Ldao = new LivroDAOimpl(em);

		List<Autor> lista = Ldao.listarAutores();

		System.out.println("Autores");

		for (Autor autor : lista) {
			System.out.println(autor.getNome());
		}

		em.close();
		fa.close();

	}

}
