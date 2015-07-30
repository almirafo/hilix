package br.com.hilix.impl.group;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hilix.entity.Group;
import br.com.hilix.util.JPAUtil;




/**
 * @generated DT_ID=none
 */

public class GroupBean
        implements GroupBeanLocal
{

    /**
     * @generated DT_ID=none
     */
   
    private EntityManager em = JPAUtil.getEntityManager();;

    /**
     * @generated DT_ID=none
     */
    public GroupBean() {
    }

    /**
     * @generated DT_ID=none
     */
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public Group persistGroup(Group group) {
    	em.getTransaction().begin();
        em.persist(group);
        em.getTransaction().commit();
        return group;
    }

    /**
     * @generated DT_ID=none
     */
    public Group mergeGroup(Group group) {
    	em.getTransaction().begin();
         em.merge(group);
        em.getTransaction().commit();
        return group;
    }

    /**
     * @generated DT_ID=none
     */
    public void removeGroup(Group group) {
        group = em.find(Group.class, group.getIdgroup());
        em.remove(group);
    }

    /**
     * @generated DT_ID=none
     */
    @SuppressWarnings("unchecked")
    public List<Group> getGroupLogin(String login) {
        return em.createNamedQuery("Group.Login").setParameter("login", login).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @SuppressWarnings("unchecked")
    public List<Group> getGroupLoginPass(String login, String senha) {
    	List<Group> rs= em.createNamedQuery("Group.LoginPass").setParameter("login", login).setParameter("senha", senha).getResultList();
        return rs;
    }

    
    /**
     * @generated DT_ID=none
     */
    @SuppressWarnings("unchecked")
    public List<Group> getGroupAll() {
        return em.createNamedQuery("Group.All").getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @SuppressWarnings("unchecked")
    public List<Group> getGroupById(Long id) {
        return em.createNamedQuery("Group.ById").setParameter("id", id).getResultList();
    }
    
}
