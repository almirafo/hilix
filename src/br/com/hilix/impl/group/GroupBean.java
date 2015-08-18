package br.com.hilix.impl.group;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hilix.entity.Grupo;
import br.com.hilix.entity.Module;
import br.com.hilix.util.GenericDAO;
import br.com.hilix.util.JPAUtil;




/**
 * @generated DT_ID=none
 */

public class GroupBean  extends GenericDAO<Long,Grupo>
        implements GroupBeanLocal
{

    /**
     * @generated DT_ID=none
     */
   
    private EntityManager em = JPAUtil.getEntityManager();

    /**
     * @generated DT_ID=none
     */
    public GroupBean(EntityManager entityManager) {
		super(entityManager);
		em = entityManager;
	}

	public List<Grupo> getByName(String name){
		return em.createQuery("FROM " + Grupo.class.getName() + " c Where c.nameGroup = :name")
				.setParameter("name",name)
				.getResultList();
	}

   

    
}
