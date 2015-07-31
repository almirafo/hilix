package br.com.hilix.impl.module;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hilix.entity.Group;
import br.com.hilix.entity.Module;
import br.com.hilix.util.GenericDAO;
import br.com.hilix.util.JPAUtil;




/**
 * @generated DT_ID=none
 */

public class ModuleBean extends GenericDAO<Long,Module>  implements ModuleBeanLocal
{
	private EntityManager em;
	public ModuleBean(EntityManager entityManager) {
		super(entityManager);
		em = entityManager;
	}
	
	public List<Module> getByName(String name){
		return em.createQuery("FROM " + Module.class.getClass().getName() + " c Where c.name = :name")
				.setParameter("name",name)
				.getResultList();
	}
}
