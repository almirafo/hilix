package com.supportcom.ocp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.supportcomm.ocp.entity.Company;
import com.supportcomm.ocp.entity.Login;
import com.supportcomm.ocp.util.JPAUtil;


public class LoginDaoImpl   implements LoginDao {
	
	public void save(Login login) {
		/*
        EntityManager em = JPAUtil.getEntityManager();
        Login l =  new Login();
        
        Company company =  new Company();
        
        CompanyDAOImpl compaDao = new CompanyDAOImpl();
        company= compaDao.load(login.getCompany());
        l = login;
        l.setCompany(company);
       EntityTransaction tx = em.getTransaction();
       if(login!=null){
       tx.begin();
           em.persist(l);
           
       tx.commit();
       em.close();
       }*/
		

		EntityManager em=  JPAUtil.getEntityManager();
		 String query ="INSERT INTO login( " +
                 " company_id, username, email, password, description," + 
                 " user_level) " +
                 " VALUES (:companyId, :username, :email, :password, :description," + 
                 ":userLevel)";
			try{
				em.getTransaction().begin();
				em.createNativeQuery(query)
				
				.setParameter("companyId", login.getCompany().getCompanyId())
				.setParameter("username", login.getUsername())
				.setParameter("email", login.getEmail())
				.setParameter("password", "change123")
				.setParameter("description", login.getDescription())
				.setParameter("userLevel", login.getUserLevel())
				
				.executeUpdate();
				em.getTransaction().commit();
			}catch(Exception e){
				em.getTransaction().rollback();
				
			}finally{
				em.close();
			}
		
	}

	public void delete(Login login) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        if(login!=null){
        tx.begin();
        login = em.find(Login.class, login.getLoginId());
            em.remove(login);
        tx.commit();
        em.close();
        }
		
	}

	public Login findById(Login login) {
		EntityManager em=  JPAUtil.getEntityManager();
		return em.find(Login.class, login);
		
	}

	public Login findByEmail(Login login) {
		EntityManager em=  JPAUtil.getEntityManager();
		
		return (Login) em.createQuery("loginFindEmail").
				setParameter("email", login.getEmail())
				.getSingleResult();
	}

	public Login FindByLogin(Login login) {
		EntityManager em=  JPAUtil.getEntityManager();
		return em.find(Login.class, login);
	}

	public List<Login> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List inte = em.createNamedQuery("loginListAll").getResultList() ;
        em.close();
    return inte;
}

	
	public Login getUserAccessLoginPass(String login, String password) {
		EntityManager em=  JPAUtil.getEntityManager();
		List list = new ArrayList();
		
		Login l =  (Login) em.createNamedQuery("getlogin")
				   .setParameter("email", login)
		           .setParameter("password", password).
		           getSingleResult();
		   
	        return l;	
	}
	
	
	 @Override
	    public void update(Login login) {

	         EntityManager em = JPAUtil.getEntityManager();
	        
	        EntityTransaction tx = em.getTransaction();
	        if(login!=null){
	        tx.begin();
	            em.merge(login);
	            
	        tx.commit();
	        em.close();
	        }
	    }

}
