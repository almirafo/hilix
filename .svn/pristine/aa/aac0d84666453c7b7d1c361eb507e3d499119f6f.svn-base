package com.supportcom.ocp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.supportcomm.ocp.entity.Ivr;
import com.supportcomm.ocp.entity.Login;
import com.supportcomm.ocp.entity.Occupation;
import com.supportcomm.ocp.util.JPAUtil;

public class IvrDAOImpl implements IvrDAO {

	@Override
	public void save(Ivr ivr) {
	EntityManager em=  JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.persist(ivr);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

	}

	@Override
	public void delete(Ivr ivr) {
		EntityManager em=  JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.remove(ivr);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}


	}

	@Override
	public Ivr findById(Ivr ivr) {
		EntityManager em=  JPAUtil.getEntityManager();
		Ivr results = new Ivr();
		try{
			em.getTransaction().begin();
			results =em.find(Ivr.class, ivr);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

		return results;
	}

	@Override
	public Ivr findByIvrCode(Ivr ivr) {

		EntityManager em=  JPAUtil.getEntityManager();
		Ivr results = new Ivr();
		try{
			em.getTransaction().begin();
			
		
			results = (Ivr)em.createNamedQuery("findByIvrCode")
						   .setParameter("ivrCode", ivr.getIvrCode())
						   .getSingleResult() ;
						
			 
			
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
			
		}

		return results;

		
	}

	public void update(Ivr ivr) {
	EntityManager em=  JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.merge(ivr);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

	}

	public List<Ivr> getListAll() { 
		EntityManager em = JPAUtil.getEntityManager();
		List inte = em.createNamedQuery("ivrListAll").getResultList() ;
		em.close();
		return inte;
	}


}
