package com.supportcom.ocp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.supportcomm.ocp.entity.Company;
import com.supportcomm.ocp.entity.Site;
import com.supportcomm.ocp.util.JPAUtil;

public class SiteDAOImpl implements SiteDAO {

	@Override
	public void save(Site site) {
        EntityManager em = JPAUtil.getEntityManager();
        
       EntityTransaction tx = em.getTransaction();
       if(site!=null){
       tx.begin();
           em.persist(site);
           
       tx.commit();
       em.close();
       }

	}

	@Override
	public List<Site> listAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List inte = em.createQuery("Select l from Site l").getResultList() ;
        em.close();
    return inte;
}

	@Override
	public Site load(Site site) {
        EntityManager em = JPAUtil.getEntityManager();
        site = em.find(Site.class, site.getSiteId());
        em.close();
        return site;
    }

	@Override
	public void remove(Site site) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        if(site!=null){
        tx.begin();
        site = em.find(Site.class, site.getSiteId());
            em.remove(site);
        tx.commit();
        em.close();
        }
    }

	@Override
	public void update(Site site) {

        EntityManager em = JPAUtil.getEntityManager();
       
       EntityTransaction tx = em.getTransaction();
       if(site!=null){
       tx.begin();
           em.merge(site);
           
       tx.commit();
       em.close();
       }
   }

}
