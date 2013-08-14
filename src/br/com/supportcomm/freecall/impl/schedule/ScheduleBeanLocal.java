package br.com.supportcomm.freecall.impl.schedule;

import java.util.List;



import br.com.supportcomm.freecall.entity.Schedule;


/**
 * @generated DT_ID=none
 */

public interface ScheduleBeanLocal
{

   
    /**
     * @generated DT_ID=none
     */
    public Schedule persistSchedule(Schedule schedule);

    /**
     * @generated DT_ID=none
     */
    public Schedule mergeSchedule(Schedule schedule);

    /**
     * @generated DT_ID=none
     */
    public void removeSchedule(Schedule schedule);

    /**
     * @generated DT_ID=none
     */
    public Schedule getScheduleByExibition(Schedule schedule);

    

    /**
     * @generated DT_ID=none
     */
    public List<Schedule> getScheduleAll();

	List<Schedule> getScheduleAllActive();
  
   
}
