package br.com.supportcomm.freecall.impl.schedule;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.supportcomm.freecall.entity.Schedule;
import br.com.supportcomm.freecall.util.JPAUtil;




/**
 * @generated DT_ID=none
 */

public class ScheduleBean
        implements ScheduleBeanLocal
{

    /**
     * @generated DT_ID=none
     */
   
    private EntityManager em = JPAUtil.getEntityManager();;

    /**
     * @generated DT_ID=none
     */
    public ScheduleBean() {
    }


    /**
     * @generated DT_ID=none
     */
    public Schedule persistSchedule(Schedule schedule) {
    	em.getTransaction().begin();
        em.persist(schedule);
        em.getTransaction().commit();
        return schedule;
    }

    /**
     * @generated DT_ID=none
     */
    public Schedule mergeSchedule(Schedule schedule) {
    	em.getTransaction().begin();
         em.merge(schedule);
        em.getTransaction().commit();
        return schedule;
    }

    /**
     * @generated DT_ID=none
     */
    public void removeSchedule(Schedule schedule) {
    	schedule = em.find(Schedule.class, schedule.getScheduleId());
        em.remove(schedule);
    }

    
   
    /**
     * @generated DT_ID=none
     */
    @Override
    public List<Schedule> getScheduleAll() {
    	List<Schedule> rs = em.createNamedQuery("Schedule.All").getResultList();
        return rs;
    }

    @Override
    public List<Schedule> getScheduleAllActive() {
    	List<Schedule> rs = em.createNamedQuery("Schedule.AllActive").getResultList();
        return rs;
    }
	

	@Override
	public Schedule getScheduleByExibition(Schedule schedule) {
		return  (Schedule) em.createNamedQuery("Schedule.ByExibition")
				.setParameter("exibitionDate", schedule.getExibitionDate())
				.getSingleResult();
	}

   
    
    

   

}
