package br.com.supportcomm.freecall.service.schedulespot;

import java.util.List;

import br.com.supportcomm.freecall.entity.Schedule;
import br.com.supportcomm.freecall.entity.ScheduleSpot;
import br.com.supportcomm.freecall.entity.Spot;
import br.com.supportcomm.freecall.impl.schedulespot.ScheduleSpotBean;
import br.com.supportcomm.freecall.impl.schedulespot.ScheduleSpotBeanLocal;
import br.com.supportcomm.freecall.impl.spot.SpotBean;
import br.com.supportcomm.freecall.impl.spot.SpotBeanLocal;



/**
 * Session Bean implementation class ScheduleSpotService
 */
public class ScheduleSpotService {

    /**
     * Default constructor. 
     */
    public ScheduleSpotService() {
    }
    
    private ScheduleSpotBeanLocal scheduleSpotBean = new ScheduleSpotBean();
    private SpotBeanLocal spotBean = new SpotBean();

	
	public ScheduleSpot persistScheduleSpot(ScheduleSpot scheduleSpot) {
		return scheduleSpotBean.persistScheduleSpot(scheduleSpot);
	}

	
	public ScheduleSpot mergeScheduleSpot(ScheduleSpot scheduleSpot) {
		return scheduleSpotBean.mergeScheduleSpot(scheduleSpot);
	}

	
	public void removeScheduleSpot(ScheduleSpot scheduleSpot) {
		scheduleSpotBean.removeScheduleSpot(scheduleSpot);
	}


	
	public List<ScheduleSpot> getScheduleSpotAll(Schedule schedule) {
		List<ScheduleSpot> rs = scheduleSpotBean.getScheduleSpostAllbySchedule(schedule);
		if (rs.isEmpty()){
			List<Spot> rsSpot = spotBean.getSpotAllActive();
			int position =1;
			for(Spot spot: rsSpot){
				ScheduleSpot scs = new ScheduleSpot();
				scs.setSchedule(schedule);
				scs.setPosition(position++);
				scs.setSpot(spot);
				rs.add(scs);
			}
		}
		
		return rs;
	}


	public void removeScheduleSpotBySchedule(Schedule schedule) {
		List<ScheduleSpot> rs = scheduleSpotBean.getScheduleSpostAllbySchedule(schedule);
		for(ScheduleSpot scheduleSpot: rs){
			  
			scheduleSpotBean.removeScheduleSpot(scheduleSpot);
		}
	}
	

	
}


