package br.com.supportcomm.freecall.impl.schedulespot;

import java.util.List;



import br.com.supportcomm.freecall.entity.Schedule;
import br.com.supportcomm.freecall.entity.ScheduleSpot;


/**
 * @generated DT_ID=none
 */

public interface ScheduleSpotBeanLocal
{

   
    /**
     * @generated DT_ID=none
     */
    public ScheduleSpot persistScheduleSpot(ScheduleSpot scheduleSpot);
    
    /**
     * @generated DT_ID=none
     */
    public ScheduleSpot mergeScheduleSpot(ScheduleSpot scheduleSpot);

    /**
     * @generated DT_ID=none
     */
    public void removeScheduleSpot(ScheduleSpot scheduleSpot);
    public void removeScheduleSpotbySchedule(Schedule schedule);

    

    /**
     * @generated DT_ID=none
     */
    public List<ScheduleSpot> getScheduleSpostAll();
    public List<ScheduleSpot> getScheduleSpostAllbySchedule(Schedule schedule);
   
}
