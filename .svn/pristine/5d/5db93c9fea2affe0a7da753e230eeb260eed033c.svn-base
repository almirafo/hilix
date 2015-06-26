package com.supportcom.ocp.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.supportcomm.ocp.entity.Ivr;
import com.supportcomm.ocp.entity.Login;
import com.supportcomm.ocp.entity.Occupation;
import com.supportcomm.ocp.entity.PieChartOccupationPortalVO;
import com.supportcomm.ocp.entity.PieChartOccupationSiteVO;
import com.supportcomm.ocp.entity.PieChartOccupationTotalVO;
import com.supportcomm.ocp.entity.PieChartOccupationVO;
import com.supportcomm.ocp.entity.Site;
import com.supportcomm.ocp.util.JPAUtil;

public class OccupationDAOImpl implements OccupationDAO {

	@Override
	public void save(Occupation occupation) {
		EntityManager em=  JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.persist(occupation);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}
	}

	@Override
	public void remove(Occupation occupation) {
		Logger logger = Logger.getLogger(OccupationDAOImpl.class.getName());
		

		EntityManager em=  JPAUtil.getEntityManager();

		try{
			em.getTransaction().begin();
			occupation = em.find(Occupation.class, occupation.getOccupationId());
			em.remove(occupation);
			em.getTransaction().commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
			logger.error(e.getMessage());	
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

	}


	@Override
	public void releaseAll(Ivr ivr) {
		EntityManager em=  JPAUtil.getEntityManager();

		try{
			em.getTransaction().begin();
			
			String hangupStatus = "RELEASE";
			
			Timestamp datetimeHangup = new Timestamp(new Date().getTime() );
			 em.createNamedQuery("occupationReleaseAll")
						   .setParameter("ivr", ivr)
						   .setParameter("hangupStatus", hangupStatus)
						   .setParameter("datetimeHangup", datetimeHangup).executeUpdate() ;
						
			 
			
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

	}

	@Override
	public Occupation findByMsisdn(Occupation occupation) {

		EntityManager em=  JPAUtil.getEntityManager();
		Occupation results = new Occupation();
		try{
			em.getTransaction().begin();
			
		
			results = (Occupation)em.createNamedQuery("occupationFindMsisdn")
						   .setParameter("msisdn", occupation.getMsisdn())
						   .getSingleResult() ;
						
			 
			
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
			
		}

		return results;

		
	}
	
	
	@Override
	public Occupation findByCallId(Occupation occupation) {

		EntityManager em=  JPAUtil.getEntityManager();
		Occupation results = new Occupation();
		try{
			em.getTransaction().begin();
			
		
			results = (Occupation)em.createNamedQuery("occupationFindCallId")
						   .setParameter("callId", occupation.getCallId())
						   .getSingleResult() ;
						
			 
			
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
			
		}

		return results;

		
	}
	
	
	
	public PieChartOccupationVO occupationChart(){
		return null;
	}

	public void update(Occupation occupation) {

		EntityManager em=  JPAUtil.getEntityManager();

		try{
			em.getTransaction().begin();
			em.merge(occupation);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

	
		
	}

	@Override
	public PieChartOccupationTotalVO totalOccupationByLogged() {
		Login login = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("logado");
		
		EntityManager em=  JPAUtil.getEntityManager();
		PieChartOccupationTotalVO results = new PieChartOccupationTotalVO();
		try{

			 
			results = (PieChartOccupationTotalVO)em.createNamedQuery("occupationTotalByLogin")
						   .setParameter("login_id",login.getLoginId())
						   .getSingleResult() ;
						
			 
			

		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			em.close();
			
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PieChartOccupationPortalVO> portalOccupationByLogged() {
		Login login = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("logado");
		
		EntityManager em=  JPAUtil.getEntityManager();
		List<PieChartOccupationPortalVO> results = new ArrayList<PieChartOccupationPortalVO>();
		try{

			 
			results = em.createNamedQuery("occupationPortalsByLogin")
						   .setParameter("login_id",login.getLoginId())
						   .getResultList() ;
						
			 
			

		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			em.close();
			
		}
		return results;
	}

	@Override
	public List<Occupation> listByIvr(Ivr ivr) {


		EntityManager em=  JPAUtil.getEntityManager();
		List<Occupation> results = new ArrayList<Occupation>();
		try{
			em.getTransaction().begin();
			
		
			results =  em.createNamedQuery("occupationListByIvr")
						   .setParameter("ivr",ivr).getResultList() ;
						
			 
			
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
			
		}

		return (List<Occupation>) results;

		
		}

	public List<PieChartOccupationSiteVO> portalOccupationSiteByLogged() {

		Login login = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("logado");
		
		EntityManager em=  JPAUtil.getEntityManager();
		List<PieChartOccupationSiteVO> results = new ArrayList<PieChartOccupationSiteVO>();
		try{

			 
			results = em.createNamedQuery("occupationSitesByLogin")
						   .setParameter("login_id",login.getLoginId())
						   .getResultList() ;
						
			 
			

		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			em.close();
			
		}
		return results;
	
	}

	public PieChartOccupationSiteVO portalOccupationSiteByLogged(Site site) {

		Login login = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("logado");
		
		EntityManager em=  JPAUtil.getEntityManager();
		PieChartOccupationSiteVO results = new PieChartOccupationSiteVO();
		try{

			 
			results = (PieChartOccupationSiteVO) em.createNamedQuery("occupationSiteByLogin")
						   .setParameter("login_id",login.getLoginId())
						   .setParameter("site_id",site.getSiteId())
						   .getSingleResult() ;
						
			 
			

		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			em.close();
			
		}
		return results;
	
	}

	public List<PieChartOccupationPortalVO> portalSiteOccupationByLogged(
			Site site) {

		Login login = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("logado");
		
		EntityManager em=  JPAUtil.getEntityManager();
		List<PieChartOccupationPortalVO> results = new ArrayList<PieChartOccupationPortalVO>();
		try{

			 
			results = em.createNamedQuery("occupationPortalSiteByLogin")
						   .setParameter("login_id",login.getLoginId())
						   .setParameter("site_id", site.getSiteId())
						   .getResultList() ;
						
			 
			

		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			em.close();
			
		}
		return results;
	
	}

}
