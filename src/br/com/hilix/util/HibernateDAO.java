package br.com.hilix.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class HibernateDAO 
<T,ID extends Serializable> 
      implements GenericDAO <T,ID>{

	private Class<T> persistentClass;
	protected EntityManager em = JPAUtil.getEntityManager();
	public HibernateDAO(Class c) {persistentClass = c;}
	
	public List<T> findAll(int startIndex, int fetchSize){
	 return em.createQuery("from "+persistentClass.getName()).getResultList();
	 
	}
	public T save(T entity) {
	 em.merge(entity);
	 return entity;
	}
	public void delete(T entity) {
	 em.remove(entity);
	}
	public void beginTransaction() {
	 em.getTransaction().begin();
	}
	public void commitTransaction() {
	 em.getTransaction().commit();
	}
}