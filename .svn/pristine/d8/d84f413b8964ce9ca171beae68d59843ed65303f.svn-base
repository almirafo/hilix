package com.supportcom.ocp.dao;

import javax.persistence.EntityManager;

import com.supportcomm.ocp.entity.OccupationHistory;
import com.supportcomm.ocp.util.JPAUtil;

public class OccupationHistoryDAOImpl implements OccupationHistoryDAO {

	@Override
	public void save(OccupationHistory occupationHistory) {
		EntityManager em=  JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.persist(occupationHistory);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}
	}


}
