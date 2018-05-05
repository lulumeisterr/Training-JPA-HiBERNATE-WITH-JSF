package br.com.fiap.BO;

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

public class LivroBO {

	protected EntityManagerFactory fa = EntityManagerFactorySingleton.getInstance();

	public void LivroCadastro(Livro l){

		EntityManager em = fa.createEntityManager();

		Autor a = new Autor();
		Livro lv = new Livro();

		LivroDAO Ldao = new LivroDAOimpl(em);

		List<Autor> aut = new ArrayList<>();
		aut.add(a);

		l.setAutores(aut);
		
		try{
			Ldao.Cadastrar(l);
			Ldao.Salvar();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}

	}

	public List<Autor> ListarTodos(){
		EntityManager em = fa.createEntityManager();
		AutorDAO Ldao = new AutorDAOimpl(em);
		List<Autor> lista = Ldao.listarAutores();
		em.close();
		return lista;

	}


	public List<Autor> ListarPorId(int id) {
		
		EntityManager em = fa.createEntityManager();
		AutorDAO Ldao = new AutorDAOimpl(em);
		List<Autor> lista = Ldao.BuscarPorId(id);
		em.close();

		return lista;
	}
	
	
	
}
