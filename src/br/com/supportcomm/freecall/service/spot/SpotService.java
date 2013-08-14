package br.com.supportcomm.freecall.service.spot;

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
public class SpotService {

    /**
     * Default constructor. 
     */
    public SpotService() {
    }
    
    private SpotBeanLocal scheduleSpotBean = new SpotBean();
    private SpotBeanLocal spotBean = new SpotBean();

	
	public Spot persistScheduleSpot(Spot spot) {
		return spotBean.persistSpot(spot);
	}

	
	public Spot mergeSpot(Spot spot) {
		return spotBean.mergeSpot(spot);
	}

	
	public void removeSpot(Spot spot) {
		spotBean.removeSpot(spot);
	}


	public Spot getSpot(Spot spot){
		
		return spotBean.findtSpot(spot);
	}
	
	public List<Spot> getSpotAll() {
			List<Spot> rsSpot = spotBean.getSpotAll();
		return rsSpot;
	}
	

	
}


