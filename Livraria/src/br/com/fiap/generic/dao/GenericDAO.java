package br.com.fiap.generic.dao;

import br.com.fiap.excecao.DBException;
import br.com.fiap.excecao.IdNotFoundException;

public interface GenericDAO <Table,Value> {
	
	void Cadastrar(Table entity);
	Table Pesquisar(Value id);
	void Alterar(Table entity);
	void remover(Value id)throws IdNotFoundException;
	void Salvar()throws DBException;

}
