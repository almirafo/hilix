package br.com.hilix.service.group;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hilix.entity.Grupo;
import br.com.hilix.impl.group.GroupBean;
import br.com.hilix.util.JPAUtil;

public class GroupService  {

		private GroupBean dao;
		private EntityManager em = JPAUtil.getEntityManager();
		public GroupService(){
			dao = new GroupBean(em);
		}
		public void save(Grupo group){
			
			dao.save(group);
		}
		
		public void remove(Grupo group){
			
			dao.delete(group,group.getIdGroup(),"idGroup");
			
		}
		
	    public void update(Grupo group) {
			//em.getTransaction().begin();
			dao.update(group);
			//em.getTransaction().commit();
	    }
		
		public Grupo find(long pk){
			return dao.getById(pk);
		}
		
		public List<Grupo> getByName(String name){
			return dao.getByName(name);
		}
		
		public List<Grupo> findAll(){
			return dao.findAll();
		}
}
