package br.com.hilix.impl.module;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hilix.entity.Module;
import br.com.hilix.util.GenericDAO;




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
	
	@Override
	public List<Module> getByName(String name){
		return em.createQuery("FROM " + Module.class.getClass().getName() + " c Where c.name = :name")
				.setParameter("name",name)
				.getResultList();
	}
}
