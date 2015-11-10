package br.com.hilix.service.canvas;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hilix.entity.Canva;
import br.com.hilix.impl.canvas.CanvaBean;
import br.com.hilix.util.JPAUtil;

public class CanvaService  {

		private CanvaBean dao;
		private EntityManager em = JPAUtil.getEntityManager();
		public CanvaService(){
			dao = new CanvaBean(em);
		}
		public void save(Canva canva){
			
			em.getTransaction().begin();
			dao.save(canva);
			em.getTransaction().commit();
		}
		
		public void remove(Canva canva){
			em.getTransaction().begin();
			//dao.delete(canva,canva.);
			em.getTransaction().commit();
		}
		
		public Canva find(long pk){
			return dao.getById(pk);
		}
		
		public List<Canva> getByName(String name){
			return dao.getByName(name);
		}
}
