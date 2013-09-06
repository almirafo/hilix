package br.com.supportcomm.freecall.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the schedule_spots database table.
 * 
 */
@Entity
@Table(name="schedule_spots")
@NamedQueries({
    @NamedQuery(name = "ScheduleSpot.All"              , query = "select u from ScheduleSpot u"),
    @NamedQuery(name = "ScheduleSpot.AllBySchedule"    , query = "select u from ScheduleSpot u where u.schedule = :schedule order by u.position"),
    @NamedQuery(name = "ScheduleSpot.removebySchedule" , query = "delete  from ScheduleSpot u where u.schedule = :schedule")
			  })


public class ScheduleSpot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCHEDULE_SPOTS_SCHEDULESPOTSID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCHEDULE_SPOTS_SCHEDULESPOTSID_GENERATOR")
	@Column(name="schedule_spots_id")
	private Long scheduleSpotsId;

	private Integer position;

	//bi-directional many-to-one association to Schedule
	@ManyToOne
	@JoinColumn(name="schedule_id")
	private Schedule schedule;

	//bi-directional many-to-one association to Spot
	@ManyToOne
	@JoinColumn(name="spot_id")
	private Spot spot;

	public ScheduleSpot() {
	}

	public Long getScheduleSpotsId() {
		return this.scheduleSpotsId;
	}

	public void setScheduleSpotsId(Long scheduleSpotsId) {
		this.scheduleSpotsId = scheduleSpotsId;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	
	public Spot getSpot() {
		return this.spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	
}