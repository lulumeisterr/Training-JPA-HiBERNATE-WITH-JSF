package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	/*
	 * PADRÃO SINGLETON - INSTANCIADO APENAS UMA VEZ
	1 - ATRIBUTO STATICO DO TIPO DO OBJ QUE É UNICO
	2 - CONSTRUTOR PRIVADO
	3 - METODO STATICO ONDE EXISTE UMA UNICA VALIDAÇÃO PARA O OBJT 
	
	 */
	
	//1 - Criando a fabrica de conexao
			private static EntityManagerFactory fa;
			
			//2 - Obtendo o Construtor privado
			private EntityManagerFactorySingleton(){
				
			}
			
			//3 - Realizando o metodo statico
			public static EntityManagerFactory getInstance(){
				if(fa == null){
					fa = Persistence.createEntityManagerFactory("exercicio");
				}
				return fa;
			}
	

}
