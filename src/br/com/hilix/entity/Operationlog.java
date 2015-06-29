package br.com.hilix.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operationlog database table.
 * 
 */
@Entity
@NamedQuery(name="Operationlog.findAll", query="SELECT o FROM Operationlog o")
public class Operationlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="operationlog_id")
	private Long operationlogId;

	@Column(name="id_user_access")
	private Long idUserAccess;

	@Column(name="schedule_id")
	private Long scheduleId;

	@Column(name="user_action")
	private String userAction;

	public Operationlog() {
	}

	public Long getOperationlogId() {
		return this.operationlogId;
	}

	public void setOperationlogId(Long operationlogId) {
		this.operationlogId = operationlogId;
	}

	public Long getIdUserAccess() {
		return this.idUserAccess;
	}

	public void setIdUserAccess(Long idUserAccess) {
		this.idUserAccess = idUserAccess;
	}

	public Long getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getUserAction() {
		return this.userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

}