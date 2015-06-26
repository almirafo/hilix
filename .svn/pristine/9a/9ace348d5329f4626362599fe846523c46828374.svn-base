/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supportcomm.ocp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author deoliva
 */
public class JPAUtil {
	
	// Use persistence.xml configuration
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ocp01");
	
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
