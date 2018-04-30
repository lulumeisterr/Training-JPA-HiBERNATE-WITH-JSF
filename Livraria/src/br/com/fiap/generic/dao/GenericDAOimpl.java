package br.com.fiap.generic.dao;

import javax.persistence.EntityManager;

import java.lang.reflect.ParameterizedType;
import br.com.fiap.excecao.DBException;
import br.com.fiap.excecao.IdNotFoundException;


public class GenericDAOimpl<Table,Value> implements GenericDAO<Table, Value>{
	
	protected EntityManager em;
	
	/*
	 * DAO QUE SERVE PARA QUALQUER CLASSE
	   Onde voc� passa por parametro (<Tabela,Chave) essa chave � a onde voc� deseja fazer a busca
	 */
	
	
	/*
	 *  Os m�todos de neg�cio espec�ficos da entidade devem ser implementados na
		classe DAO filha e n�o na DAO gen�rica!
	 */
	
	
	
	// Pegando os valores em tempo real da tabela
	//.class da entidade (usado na busca)
	
	private Class<Table> classe;
	
	@SuppressWarnings("all")
	public GenericDAOimpl(EntityManager em) {
		this.em = em;
		classe = (Class<Table>) ((ParameterizedType)getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	@Override
	public void Cadastrar(Table entity) {
		em.persist(entity);
	}

	@Override
	public Table Pesquisar(Value id) {
		return em.find(classe, id);
	}

	@Override
	public void Alterar(Table entity) {
		em.merge(entity);
	}

	@Override
	public void remover(Value id)throws IdNotFoundException{
		Table buscarEntidade = Pesquisar(id);
		
		if(buscarEntidade == null){
			throw new IdNotFoundException("Entidade n�o encontrada");
		}
		
		em.remove(id);
		
	}

	@Override
	public void Salvar()throws DBException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
			
		}catch(Exception e) {
			//Verificando se a transacao esta ativa
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}else {
				throw new DBException("Erro no commit", e);
			}
			
		}
		
	}



}
