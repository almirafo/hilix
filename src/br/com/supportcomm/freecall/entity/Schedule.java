package br.com.supportcomm.freecall.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Schedule.All", query = "select u from Schedule u"),
    @NamedQuery(name = "Schedule.AllActive", query = "select u from Schedule u where u.enabled ='1'")
			  })

public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCHEDULE_SCHEDULEID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCHEDULE_SCHEDULEID_GENERATOR")
	@Column(name="schedule_id")
	private Long scheduleId;

	private String enabled;

	@Temporal(TemporalType.DATE)
	@Column(name="exibition_date")
	private Date exibitionDate;

	@Column(name="operation_datetime")
	private Timestamp operationDatetime;

	@Column(name="schedule_description")
	private String scheduleDescription;

	public Schedule() {
	}

	public Long getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public Date getExibitionDate() {
		return this.exibitionDate;
	}

	public void setExibitionDate(Date exibitionDate) {
		this.exibitionDate = exibitionDate;
	}

	public Timestamp getOperationDatetime() {
		return this.operationDatetime;
	}

	public void setOperationDatetime(Timestamp operationDatetime) {
		this.operationDatetime = operationDatetime;
	}

	public String getScheduleDescription() {
		return this.scheduleDescription;
	}

	public void setScheduleDescription(String scheduleDescription) {
		this.scheduleDescription = scheduleDescription;
	}

}