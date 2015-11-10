package br.com.hilix.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;
 


import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDAO<PK, T> {
    private EntityManager entityManager;
 
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }
 
    public void save(T entity) {
    	entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        
    }
 
    public void update(T entity) {
    	entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }
 
    public void delete(T entity,PK pk, String _attributeName) {
    	entityManager.getTransaction().begin();
        //entityManager.remove(entity);
        
    	entityManager.createQuery("Delete from " + getTypeClass().getName() + " where " + _attributeName+ " = " + pk).executeUpdate();
    	entityManager.getTransaction().commit();
    }
 
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
    
    public Object queryByRange(String jpqlStmt, int firstResult,
            int maxResults) {
		Query query = entityManager.createQuery(jpqlStmt);
			if (firstResult > 0) {
			query = query.setFirstResult(firstResult);
			}
			if (maxResults > 0) {
			query = query.setMaxResults(maxResults);
			}
			
			return query.getResultList();
		}
}