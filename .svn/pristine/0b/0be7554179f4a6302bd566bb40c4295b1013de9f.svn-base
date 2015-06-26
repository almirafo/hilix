package com.supportcomm.ocp.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;




/**
 * The persistent class for the occupation database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="occupationFindMsisdn" ,query="select l from Occupation l where l.msisdn = :msisdn and l.datetimeHangup is null"),
	@NamedQuery(name="occupationFindCallId" ,query="select l from Occupation l where l.callId = :callId"),
	@NamedQuery(name="occupationReleaseAll" ,query="update Occupation o set o.datetimeHangup =:datetimeHangup, hangupStatus = :hangupStatus where o.ivr = :ivr and hangupStatus is null"),
	@NamedQuery(name="occupationListByIvr" ,query="select l from Occupation l where l.ivr = :ivr and l.hangupStatus = 'RELEASE'")
}
)

@NamedNativeQueries({
	@NamedNativeQuery (name="occupationChartPie",  query="select site.name as name, ivr.ivr_code, ivr.capacity ,count(occupation.occupation_id) "+ 
														" from occupation , site, ivr "+
														" where occupation.ivr_id = ivr.ivr_id"+
														"  and ivr.site_id = site.site_id"+
														"  and occupation.datetime_hangup is null"+
														" group by site.name, ivr.ivr_code,ivr.capacity",resultClass = PieChartOccupationVO.class),

	
	
														
														
														
														
	
	@NamedNativeQuery (name="occupationTotalByLogin",  query=	
			 "Select count(occupation.occupation_id) used , ( Select sum(ivr.capacity) from site,ivr "+ 
						"		 where ivr.site_id = site.site_id "+ 
						"		  and site.site_id in (select site_id from portal, portal_login where portal_login.portal_id = portal.portal_id and portal_login.login_id = :login_id )) as total_capacity  from occupation, portal_login "+ 
						"		 where occupation.portal_id=  portal_login.portal_id "+ 
						"           and occupation.datetime_hangup is null " +
						"		   and portal_login.login_id = :login_id "
															,resultClass = PieChartOccupationTotalVO.class),
															
															
@NamedNativeQuery (name="occupationPortalsByLogin",  query=	
	" select  portal.name as portal_name, count(distinct occupation.occupation_id) as used  " +
	"  from occupation, portal, portal_login " +
	" where occupation.portal_id  = portal.portal_id       and " +
	"       portal.portal_id      = portal_login.portal_id and " +
	"       portal_login.login_id = :login_id            and " +
	"       occupation.datetime_hangup is null " +
	"group by portal.name " ,resultClass = PieChartOccupationPortalVO.class)	,
	

	
	@NamedNativeQuery (name="occupationPortalSiteByLogin",  query=		
	" select  portal.name as portal_name, count(distinct occupation.occupation_id) as used  " +
	"  from occupation, portal, portal_login  " +
	" where occupation.portal_id  = portal.portal_id       and  " +
	"       portal.portal_id      = portal_login.portal_id and  " +
	"       portal_login.login_id = :login_id            and  " +
	"       portal.site_id = :site_id and " +
	"       occupation.datetime_hangup is null  " +
	       
	"group by portal.name ,portal.site_id " ,resultClass = PieChartOccupationPortalVO.class)	,
	
	
	
	
	
	@NamedNativeQuery (name="occupationSitesByLogin",  query=
	"Select site.name as name , count(occupation.occupation_id) used ,  siteCapacity.totalCapacity  as total_capacity "+

	"					         from occupation, portal_login, portal ,site, "+

	"					            ( Select site.site_id, sum(ivr.capacity)  totalCapacity from site,ivr "+  
	"							 where ivr.site_id = site.site_id   "+
	"							  and site.site_id in (select site_id from portal, portal_login where portal_login.portal_id = portal.portal_id and portal_login.login_id = :login_id ) group by site.site_id) as siteCapacity "+

								  
	"							 where occupation.portal_id=  portal_login.portal_id  "+
	"							   and  portal_login.portal_id = portal.portal_id "+
	"							   and portal.site_id = site.site_id "+
	"							   and site.site_id = siteCapacity.site_id "+
	"					           and occupation.datetime_hangup is null "+
	"							   and portal_login.login_id = :login_id "+
	" group by site.name,siteCapacity.totalcapacity"
	
	,resultClass = PieChartOccupationSiteVO.class)	,
		
	
	@NamedNativeQuery (name="occupationSiteByLogin",  query=
	"Select site.name as name , count(occupation.occupation_id) used ,  siteCapacity.totalCapacity  as total_capacity "+

	"					         from occupation, portal_login, portal ,site, "+

	"					            ( Select site.site_id, sum(ivr.capacity)  totalCapacity from site,ivr "+  
	"							 where ivr.site_id = site.site_id   "+
	"							  and site.site_id in (select site_id from portal, portal_login where portal_login.portal_id = portal.portal_id and portal_login.login_id = :login_id ) group by site.site_id) as siteCapacity "+

								  
	"							 where occupation.portal_id=  portal_login.portal_id  "+
	"							   and  portal_login.portal_id = portal.portal_id "+
	"							   and portal.site_id = site.site_id "+
	"							   and site.site_id = siteCapacity.site_id "+
	"					           and occupation.datetime_hangup is null "+
	"							   and portal_login.login_id = :login_id "+
	"							   and site.site_id = :site_id "+
	" group by site.name,siteCapacity.totalcapacity"
	
	,resultClass = PieChartOccupationSiteVO.class)	
	
	
	
	
	
	
})

public class Occupation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="occupation_id")
	private Long occupationId;

	@Column(name="datetime_hangup")
	private Timestamp datetimeHangup;

	@Column(name="datetime_incall")
	private Timestamp datetimeIncall;

	@Column(name="hangup_status")
	private String hangupStatus;

	@Column(name="call_id")
	private String callId;
	
	
	private String msisdn;

	//bi-directional many-to-one association to Portal
	@ManyToOne
	@JoinColumn(name="ivr_id")
	private Ivr ivr;

	
	@ManyToOne
	@JoinColumn(name="portal_id")
	private Portal portal;
	
	
	
	
	
	public Occupation() {
	}

	public Long getOccupationId() {
		return this.occupationId;
	}

	public void setOccupationId(Long occupationId) {
		this.occupationId = occupationId;
	}

	public Timestamp getDatetimeHangup() {
		return this.datetimeHangup;
	}

	public void setDatetimeHangup(Timestamp datetimeHangup) {
		this.datetimeHangup = datetimeHangup;
	}

	public Timestamp getDatetimeIncall() {
		return this.datetimeIncall;
	}

	public void setDatetimeIncall(Timestamp datetimeIncall) {
		this.datetimeIncall = datetimeIncall;
	}

	public String getHangupStatus() {
		return this.hangupStatus;
	}

	public void setHangupStatus(String hangupStatus) {
		this.hangupStatus = hangupStatus;
	}

	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}


	public Ivr getIvr() {
		return ivr;
	}

	public void setIvr(Ivr ivr) {
		this.ivr = ivr;
	}

	
	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}	
	
}