package com.supportcomm.ocp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the ivr database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="ivrListAll" ,query="select l from Ivr l"),
	@NamedQuery(name="findByIvrCode" ,query="Select l from Ivr l where l.ivrCode= :ivrCode")
})
public class Ivr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ivr_id")
	private Long ivrId;

	@Column(name="ivr_code")
	private String ivrCode;

	
	@ManyToOne
	@JoinColumn(name="site_id")
	private Site site;
    
	@Column(name ="capacity")
	private Long capacity;
	
	
	public Ivr() {
	}



	public Long getIvrId() {
		return ivrId;
	}



	public void setIvrId(Long ivrId) {
		this.ivrId = ivrId;
	}



	public String getIvrCode() {
		return ivrCode;
	}



	public void setIvrCode(String ivrCode) {
		this.ivrCode = ivrCode;
	}



	public Site getSite() {
		return site;
	}



	public void setSite(Site site) {
		this.site = site;
	}



	public Long getCapacity() {
		return capacity;
	}



	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}



	

}