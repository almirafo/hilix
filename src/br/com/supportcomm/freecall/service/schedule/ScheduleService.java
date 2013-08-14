package br.com.supportcomm.freecall.service.schedule;

import java.util.List;

import br.com.supportcomm.freecall.entity.Schedule;
import br.com.supportcomm.freecall.impl.schedule.ScheduleBean;
import br.com.supportcomm.freecall.impl.schedule.ScheduleBeanLocal;

/**
 * Session Bean implementation class ScheduleService
 */
public class ScheduleService {

    /**
     * Default constructor. 
     */
    public ScheduleService() {
    }
    
    private ScheduleBeanLocal scheduleBean = new ScheduleBean();


	
	public Schedule persistSchedule(Schedule schedule) {
		return scheduleBean.persistSchedule(schedule);
	}

	
	public Schedule mergeSchedule(Schedule schedule) {
		return scheduleBean.mergeSchedule(schedule);
	}

	
	public void removeSchedule(Schedule schedule) {
		scheduleBean.removeSchedule(schedule);
	}


	
	public List<Schedule> getScheduleAll() {
		return scheduleBean.getScheduleAll();
	}

	public List<Schedule> getScheduleAllActive() {
		return scheduleBean.getScheduleAllActive();
	}

	
	public Schedule getScheduleByExibition(Schedule schedule) {
		return  scheduleBean.getScheduleByExibition(schedule);
	}
	
}


