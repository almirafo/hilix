package com.supportcom.ocp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.supportcomm.ocp.entity.Portal;
import com.supportcomm.ocp.entity.PortalLoginVO;
import com.supportcomm.ocp.util.JPAUtil;

public class PortalDAOImpl implements PortalDAO {

	@Override
	public void save(Portal portal) {
	EntityManager em=  JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.persist(portal);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

	}

	@Override
	public void delete(Portal portal) {
		EntityManager em=  JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			portal = em.find(Portal.class, portal.getPortalId());
			em.remove(portal);
			em.getTransaction().commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}


	}

	@Override
	public Portal findById(Portal portal) {
		EntityManager em=  JPAUtil.getEntityManager();
		Portal results = new Portal();
		try{
			em.getTransaction().begin();
			results =em.find(Portal.class, portal.getPortalId());
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

		return results;
	}

	@Override
	public Portal findByPortalNumber(Portal portal) {

		EntityManager em=  JPAUtil.getEntityManager();
		Portal results = new Portal();
		try{
			em.getTransaction().begin();
			
		
			results = (Portal)em.createNamedQuery("findByPortalNumber")
						   .setParameter("portalNumber", portal.getPortalNumber())
						   .getSingleResult() ;
						
			 
			
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
			
		}

		return results;

		
	}

	public void update(Portal portal) {
	EntityManager em=  JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.merge(portal);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

	}

	public List<Portal> listAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List inte = em.createNamedQuery("portalListAll").getResultList() ;
        em.close();
    return inte;
}

	
	public void removeAllPortalsLogin( Long loginId){
	    String query="delete from portal_login where login_id = :loginId";

		EntityManager em=  JPAUtil.getEntityManager();
			
			try{
				em.getTransaction().begin();
				em.createNativeQuery(query)
				.setParameter("loginId", loginId)
				.executeUpdate();
				em.getTransaction().commit();
			}catch(Exception e){
				em.getTransaction().rollback();
				
			}finally{
				em.close();
			}
	    
	    
	}
	@Override
	public void associatePortalLogin(Long portalId, Long loginId) {

		    String query="insert into portal_login  (login_id, portal_id) values(:loginId, :portalId)";
		    

			EntityManager em=  JPAUtil.getEntityManager();
				
				try{
					em.getTransaction().begin();
					em.createNativeQuery(query)
					.setParameter("loginId", loginId)
					.setParameter("portalId", portalId).executeUpdate();
					em.getTransaction().commit();
				}catch(Exception e){
					em.getTransaction().rollback();
					
				}finally{
					em.close();
				}
		    
		    
		}

	public List<PortalLoginVO> listAllByLogin(Long loginId) {

        EntityManager em = JPAUtil.getEntityManager();
        String query="SELECT " +
        		"    case when P.login_id is null then :loginId else P.login_id end   as loginId ," +
        		"	 portal.portal_id as portalId," +
        		"	 case when  P.portal_id is null then false else true end as checked ," +
        		"	 portal.name            as portalName " +

        		"	FROM portal LEFT JOIN  (SELECT * FROM portal_login WHERE portal_login.login_id = :loginId)  AS P ON (portal.portal_id = P.portal_id)" ;

        
        
        List<PortalLoginVO> inte = em.createNativeQuery(query,PortalLoginVO.class).
        						   setParameter("loginId", loginId).
        		                   getResultList() ;
        em.close();
		return inte;
	}		
	

}
