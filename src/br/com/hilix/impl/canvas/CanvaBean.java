package br.com.hilix.impl.canvas;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hilix.entity.Canva;
import br.com.hilix.entity.Module;
import br.com.hilix.util.GenericDAO;




/**
 * @generated DT_ID=none
 */

public class CanvaBean extends GenericDAO<Long,Canva>  implements CanvaBeanLocal
{
	private EntityManager em;
	public CanvaBean(EntityManager entityManager) {
		super(entityManager);
		em = entityManager;
	}
	
	public List<Canva> getByName(String name){
		return em.createQuery("FROM " + Module.class.getClass().getName() + " c Where c.nameCanvas = :name")
				.setParameter("name",name)
				.getResultList();
	}
}
