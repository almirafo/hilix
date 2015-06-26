package com.supportcomm.ocp.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CreateClass {

	
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ocp01");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			
			List list = new ArrayList();
			
			list =  em.createNamedQuery("listaLogin").getResultList();
		
			System.out.println("check");
			
		
	
			
			System.out.println(list.get(0));
			
			
	
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			emf.close();
		}

		System.out.println("It is over");
	}

}
