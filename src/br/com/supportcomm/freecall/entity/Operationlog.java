package br.com.supportcomm.freecall.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operationlog database table.
 * 
 */
@Entity
public class Operationlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OPERATIONLOG_OPERATIONLOGID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OPERATIONLOG_OPERATIONLOGID_GENERATOR")
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