package br.com.hilix.service.module;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hilix.entity.Module;
import br.com.hilix.impl.module.ModuleBean;
import br.com.hilix.util.JPAUtil;

public class ModuleService  {

		private ModuleBean dao;
		private EntityManager em = JPAUtil.getEntityManager();
		public ModuleService(){
			dao = new ModuleBean(em);
		}
		public void save(Module module){
			
			em.getTransaction().begin();
			dao.save(module);
			em.getTransaction().commit();
		}
		
		public void remove(Module module){
			em.getTransaction().begin();
			dao.delete(module,module.getIdmodule(),"idModule");
			em.getTransaction().commit();
		}
		
		public Module find(long pk){
			return dao.getById(pk);
		}
		
		public List<Module> getByName(String name){
			return dao.getByName(name);
		}
}
