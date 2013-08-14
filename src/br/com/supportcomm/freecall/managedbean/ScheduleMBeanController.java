package br.com.supportcomm.freecall.managedbean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.supportcomm.freecall.entity.Operationlog;
import br.com.supportcomm.freecall.entity.Schedule;
import br.com.supportcomm.freecall.entity.ScheduleSpot;
import br.com.supportcomm.freecall.entity.Spot;
import br.com.supportcomm.freecall.entity.UserAccess;
import br.com.supportcomm.freecall.service.operationlog.OperationlogService;
import br.com.supportcomm.freecall.service.schedule.ScheduleService;
import br.com.supportcomm.freecall.service.schedulespot.ScheduleSpotService;
import br.com.supportcomm.freecall.service.spot.SpotService;

	@ManagedBean(name="schedule")
	@ViewScoped
	public class ScheduleMBeanController implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private ScheduleModel eventModel;
		
		private ScheduleEvent event = new DefaultScheduleEvent();
		
		
		private List<ScheduleSpot> scheduleSpots =  new ArrayList<ScheduleSpot>();
		

		private ScheduleService scheduleService =  new ScheduleService();
		private OperationlogService operationlogService = new OperationlogService();
		
		private ScheduleSpotService scheduleSpotService = new ScheduleSpotService();
		public ScheduleMBeanController() {
			
			
			
			eventModel = new DefaultScheduleModel();
			
			List<Schedule> schedules = scheduleService.getScheduleAllActive();
			
			for(Schedule schedule: schedules){
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
				Date dateini = new Date();
				Date datefim = new Date();
				try {
					dateini   = sdf.parse(schedule.getExibitionDate().toString() + " 00:00");
					 datefim  = sdf.parse(schedule.getExibitionDate().toString() + " 23:59");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				DefaultScheduleEvent ds = new DefaultScheduleEvent();
				ds.setData(schedule.getScheduleId());
				ds.setAllDay(true);
				ds.setTitle(schedule.getScheduleDescription());
				ds.setStartDate(dateini);
				ds.setEndDate(datefim);
				
				
				eventModel.addEvent(ds);
				//eventModel.addEvent((new DefaultScheduleEvent(schedule.getScheduleDescription(),  dateini ,datefim));
			}
			
			
			
		}
		
		public ScheduleModel getEventModel() {
			return eventModel;
		}
		

		
		public ScheduleEvent getEvent() {
			return event;
		}

		public void setEvent(ScheduleEvent event) {
			this.event = event;
		}
		
		public void addEvent(ActionEvent actionEvent) {
			Schedule schedule = new Schedule();
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			UserAccess user = (UserAccess) request.getSession().getAttribute("usuarioAutenticado");
			if(event.getId() == null){
				eventModel.addEvent(event);
			    // adiciono na base				
				schedule.setExibitionDate(event.getStartDate());
				schedule.setScheduleDescription(event.getTitle());
				schedule.setEnabled("1");
				schedule.setOperationDatetime( new Timestamp(System.currentTimeMillis()));
				scheduleService.persistSchedule(schedule);
				((DefaultScheduleEvent) event).setData(schedule.getScheduleId());
				//salvando as configurações
				int position=1;
				
				
				for(Object idSpot:  scheduleSpots){
					
					ScheduleSpot  scs = new ScheduleSpot();
					Spot spot = new Spot();
					spot.setSpotId(Long.parseLong((String) idSpot));
					SpotService spotService = new SpotService();
					spot = spotService.getSpot(spot);

					scs.setSchedule(schedule);
					scs.setPosition(position++);
					scs.setSpot(spot);
					scheduleSpotService.persistScheduleSpot(scs);
				}
				Operationlog operationlog = new Operationlog();
				operationlog.setIdUserAccess(user.getIdUserAccess());
				operationlog.setScheduleId(schedule.getScheduleId());
				operationlog.setUserAction("NEW");
				operationlogService.persistSchedule(operationlog);
				
			}
			else{
				eventModel.updateEvent(event);
			    // atualizar a base

				schedule.setScheduleId((Long) event.getData());
				schedule.setScheduleDescription(event.getTitle());
				schedule.setExibitionDate(event.getStartDate());
				schedule.setEnabled("1");
				schedule.setOperationDatetime( new Timestamp(System.currentTimeMillis()));
				scheduleService.mergeSchedule(schedule);
				//salvando as configurações
				int position=1;
				scheduleSpotService.removeScheduleSpotBySchedule(schedule);
				for(Object idSpot:  scheduleSpots){
					
					ScheduleSpot  scs = new ScheduleSpot();
					Spot spot = new Spot();
					spot.setSpotId(Long.parseLong((String) idSpot));
					SpotService spotService = new SpotService();
					spot = spotService.getSpot(spot);
					scs.setSchedule(schedule);
					scs.setPosition(position++);
					scs.setSpot(spot);
					scheduleSpotService.persistScheduleSpot(scs);
				}
				Operationlog operationlog = new Operationlog();
				operationlog.setIdUserAccess(user.getIdUserAccess());
				operationlog.setScheduleId(schedule.getScheduleId());
				operationlog.setUserAction("UPDATE");
				operationlogService.persistSchedule(operationlog);

				
			}
			event = new DefaultScheduleEvent();
		}

		public void removeEvent(ActionEvent actionEvent) {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			UserAccess user = (UserAccess) request.getSession().getAttribute("usuarioAutenticado");
			Schedule schedule = new Schedule();
			if(event.getId() != null){
				eventModel.deleteEvent(event);
				
				schedule.setScheduleId((Long) event.getData());
				schedule.setScheduleDescription(event.getTitle());
				schedule.setExibitionDate(event.getStartDate());
				schedule.setEnabled("0");
				schedule.setOperationDatetime( new Timestamp(System.currentTimeMillis()));
				scheduleService.mergeSchedule(schedule);

				Operationlog operationlog = new Operationlog();
				operationlog.setIdUserAccess(user.getIdUserAccess());
				operationlog.setScheduleId(schedule.getScheduleId());
				operationlog.setUserAction("REMOVE");
				operationlogService.persistSchedule(operationlog);

				
			    // removo da base
			}
			event = new DefaultScheduleEvent();
		}

		
		
		
		public void onEventSelect(SelectEvent selectEvent) {
			event = (ScheduleEvent) selectEvent.getObject();
			this.scheduleSpots = new ArrayList<ScheduleSpot>();
			Schedule schedule =  new Schedule();
			schedule.setScheduleId(Long.parseLong( event.getData().toString()));
			this.scheduleSpots = scheduleSpotService.getScheduleSpotAll(schedule);
			
		}
		
		public void onDateSelect(SelectEvent selectEvent) {
			DefaultScheduleEvent ds = new DefaultScheduleEvent();
			
			ds.setAllDay(true);
			ds.setTitle("");
			ds.setStartDate((Date) selectEvent.getObject());
			ds.setEndDate( (Date) selectEvent.getObject());
			Schedule schedule =  new Schedule();
			schedule.setScheduleId(0l);
			this.scheduleSpots = new ArrayList<ScheduleSpot>();
			this.scheduleSpots = scheduleSpotService.getScheduleSpotAll(schedule);
			event = ds;
		}
		

		
		private void addMessage(FacesMessage message) {
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

		public List<ScheduleSpot> getScheduleSpot() {
			return scheduleSpots;
		}

		public void setScheduleSpot(List<ScheduleSpot> scheduleSpot) {
			this.scheduleSpots = scheduleSpot;
		}


	}
