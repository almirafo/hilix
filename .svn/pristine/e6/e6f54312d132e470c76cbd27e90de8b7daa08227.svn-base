package br;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectTesteJPA {

	/**
	 * @param args
	 */

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("primeTeste");

	public EntityManager getConect(){
		
		return emf.createEntityManager();

	}

}
