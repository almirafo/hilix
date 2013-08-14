package br.com.supportcomm.freecall.impl.schedulespot;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.supportcomm.freecall.entity.Schedule;
import br.com.supportcomm.freecall.entity.ScheduleSpot;
import br.com.supportcomm.freecall.util.JPAUtil;




/**
 * @generated DT_ID=none
 */

public class ScheduleSpotBean
        implements ScheduleSpotBeanLocal
{

    /**
     * @generated DT_ID=none
     */
   
    private EntityManager em = JPAUtil.getEntityManager();;

    /**
     * @generated DT_ID=none
     */
    public ScheduleSpotBean() {
    }


    /**
     * @generated DT_ID=none
     */
    public ScheduleSpot persistScheduleSpot(ScheduleSpot scheduleSpot) {
    	em.getTransaction().begin();
        em.persist(scheduleSpot);
        em.getTransaction().commit();
        return scheduleSpot;
    }

    /**
     * @generated DT_ID=none
     */
    public ScheduleSpot mergeScheduleSpot(ScheduleSpot scheduleSpot) {
    	em.getTransaction().begin();
         em.merge(scheduleSpot);
        em.getTransaction().commit();
        return scheduleSpot;
    }

    /**
     * @generated DT_ID=none
     */
    public void removeScheduleSpot(ScheduleSpot scheduleSpot) {
    	scheduleSpot = em.find(ScheduleSpot.class, scheduleSpot.getScheduleSpotsId());
        em.remove(scheduleSpot);
    }

    public void removeScheduleSpotbySchedule(Schedule schedule){
    	em.createNamedQuery("ScheduleSpot.removebySchedule")
        .setParameter("schedule", schedule)
        .executeUpdate();
        
    	
    }
    
    
    
    public List<ScheduleSpot> getScheduleSpostAllbySchedule(Schedule schedule){
    	@SuppressWarnings("unchecked")
		List<ScheduleSpot> rs = em.createNamedQuery("ScheduleSpot.AllBySchedule")
    			                .setParameter("schedule", schedule)
    			                .getResultList();
    	return rs;
    }



	@Override
	public List<ScheduleSpot> getScheduleSpostAll() {
		List<ScheduleSpot> rs = em.createNamedQuery("ScheduleSpot.All").getResultList();
        return rs;
	}


   

}
