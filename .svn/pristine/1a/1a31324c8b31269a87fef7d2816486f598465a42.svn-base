package br;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_history database table.
 * 
 */
@Entity
@Table(name="user_history")
@NamedQuery(name="teste",query="select u from UserHistory u")
public class UserHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String action;

	@Column(name="date_insered")
	private Timestamp dateInsered;

	@Column(name="id_campanha")
	private Long idCampanha;

	@Column(name="id_spot")
	private Long idSpot;

	@Column(name="id_user_access")
	private Long idUserAccess;

	@Column(name="user_login")
	private String userLogin;

	@Column(name="user_type")
	private Long userType;

	public UserHistory() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Timestamp getDateInsered() {
		return this.dateInsered;
	}

	public void setDateInsered(Timestamp dateInsered) {
		this.dateInsered = dateInsered;
	}

	public Long getIdCampanha() {
		return this.idCampanha;
	}

	public void setIdCampanha(Long idCampanha) {
		this.idCampanha = idCampanha;
	}

	public Long getIdSpot() {
		return this.idSpot;
	}

	public void setIdSpot(Long idSpot) {
		this.idSpot = idSpot;
	}

	public Long getIdUserAccess() {
		return this.idUserAccess;
	}

	public void setIdUserAccess(Long idUserAccess) {
		this.idUserAccess = idUserAccess;
	}

	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public Long getUserType() {
		return this.userType;
	}

	public void setUserType(Long userType) {
		this.userType = userType;
	}

}