package br.com.supportcomm.freecall.impl.operationlog;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.supportcomm.freecall.entity.Operationlog;
import br.com.supportcomm.freecall.entity.Spot;
import br.com.supportcomm.freecall.util.JPAUtil;




/**
 * @generated DT_ID=none
 */

public class OperationlogBean
        implements OperationlogBeanLocal
{

    /**
     * @generated DT_ID=none
     */
   
    private EntityManager em = JPAUtil.getEntityManager();;

    /**
     * @generated DT_ID=none
     */
    public OperationlogBean() {
    }


    /**
     * @generated DT_ID=none
     */
    public Operationlog persistOperationlog(Operationlog operationlog){
    	em.getTransaction().begin();
        em.persist(operationlog);
        em.getTransaction().commit();
        return operationlog;
    }

   
   
    
    

   

}
