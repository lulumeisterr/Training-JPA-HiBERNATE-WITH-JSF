package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.daoImpl.AutorDAOimpl;
import br.com.fiap.daoImpl.LivroDAOimpl;
import br.com.fiap.daoInterface.AutorDAO;
import br.com.fiap.daoInterface.LivroDAO;
import br.com.fiap.model.entity.Autor;
import br.com.fiap.model.entity.Livro;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory fa = EntityManagerFactorySingleton.getInstance();
			EntityManager em = fa.createEntityManager();
			
			LivroDAO Ldao = new LivroDAOimpl(em);
			AutorDAO Adao = new AutorDAOimpl(em);
			
			Autor a = new Autor("Joana");
			Livro l = new Livro("Teste" , "1021" , 25 , "27/02/98");
			
			
			List<Autor> aut = new ArrayList<>();
			aut.add(a);
			
			l.setAutores(aut);
	
			try{
				
				Ldao.Cadastrar(l);
				Ldao.Salvar();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			em.close();
			fa.close();
	}
}
