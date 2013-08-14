package br.com.supportcomm.freecall.impl.spot;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.supportcomm.freecall.entity.Spot;
import br.com.supportcomm.freecall.util.JPAUtil;




/**
 * @generated DT_ID=none
 */

public class SpotBean
        implements SpotBeanLocal
{

    /**
     * @generated DT_ID=none
     */
   
    private EntityManager em = JPAUtil.getEntityManager();;

    /**
     * @generated DT_ID=none
     */
    public SpotBean() {
    }


    /**
     * @generated DT_ID=none
     */
    public Spot persistSpot(Spot spot) {
    	em.getTransaction().begin();
        em.persist(spot);
        em.getTransaction().commit();
        return spot;
    }

    /**
     * @generated DT_ID=none
     */
    public Spot mergeSpot(Spot spot) {
    	em.getTransaction().begin();
         em.merge(spot);
        em.getTransaction().commit();
        return spot;
    }

    /**
     * @generated DT_ID=none
     */
    public void removeSpot(Spot spot) {
    	spot = em.find(Spot.class, spot.getSpotId());
        em.remove(spot);
    }

    public Spot findtSpot(Spot spot){
    	spot = em.find(Spot.class, spot.getSpotId());
    	return spot;
    }
   
    /**
     * @generated DT_ID=none
     */
    @SuppressWarnings("unchecked")
    public List<Spot> getSpotAll() {
    	List<Spot> rs = em.createNamedQuery("Spot.All").getResultList();
        return rs;
    }


    @SuppressWarnings("unchecked")
    public List<Spot> getSpotAllActive() {
    	List<Spot> rs = em.createNamedQuery("Spot.AllActive").getResultList();
        return rs;
    }


   
    
    

   

}
