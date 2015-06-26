/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supportcom.ocp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.supportcomm.ocp.entity.Company;
import com.supportcomm.ocp.util.JPAUtil;


/**
 *
 * @author deoliva
 */
public class CompanyDAOImpl  implements CompanyDAO{

    @Override
    public void save(Company company) {
         EntityManager em = JPAUtil.getEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        if(company!=null){
        tx.begin();
            em.persist(company);
            
        tx.commit();
        em.close();
        }
    }

    @Override
    public List<Company> lista() {
            EntityManager em = JPAUtil.getEntityManager();
            List inte = em.createNamedQuery("companyListAll").getResultList() ;
            em.close();
        return inte;
    }

    @Override
    public Company load(Company company) {
        EntityManager em = JPAUtil.getEntityManager();
        company = em.find(Company.class, company.getCompanyId());
        em.close();
        return company;
    }

    @Override
    public void remove(Company company) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        if(company!=null){
        tx.begin();
        	company = em.find(Company.class, company.getCompanyId());
            em.remove(company);
        tx.commit();
        em.close();
        }
    }

    @Override
    public void update(Company company) {

         EntityManager em = JPAUtil.getEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        if(company!=null){
        tx.begin();
            em.merge(company);
            
        tx.commit();
        em.close();
        }
    }
    
    
}
