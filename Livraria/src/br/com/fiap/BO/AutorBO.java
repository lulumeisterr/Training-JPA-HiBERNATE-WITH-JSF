package br.com.fiap.BO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.daoImpl.AutorDAOimpl;
import br.com.fiap.daoInterface.AutorDAO;
import br.com.fiap.model.entity.Autor;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class AutorBO {

	protected EntityManagerFactory fa = EntityManagerFactorySingleton.getInstance();

	/*
	 * Cadastrando
	 */

	public void AutorCadastro(Autor autor) {

		EntityManager em = fa.createEntityManager();
		
		AutorDAO dao = new AutorDAOimpl(em);	
		
		try {
			
		dao.Cadastrar(autor);
		dao.Salvar();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}

	}
	
	

}
