package com.supportcomm.ocp.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the portal database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="portalListAll" ,query="select l from Portal l"),
	@NamedQuery(name="findByPortalNumber" ,query="Select l from Portal l where l.portalNumber= :portalNumber")
})


public class Portal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="portal_id")
	private Long portalId;

	private String description;

	private String dnid;

	private String name;

	@Column(name="portal_number")
	private String portalNumber;

	

	//bi-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name="site_id")
	private Site site;

	//bi-directional many-to-many association to Login
	@ManyToMany
	@JoinTable(
		name="portal_login"
		, joinColumns={
			@JoinColumn(name="portal_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="login_id")
			}
		)
	private List<Login> logins;

	public Portal() {
	}

	public Long getPortalId() {
		return this.portalId;
	}

	public void setPortalId(Long portalId) {
		this.portalId = portalId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDnid() {
		return this.dnid;
	}

	public void setDnid(String dnid) {
		this.dnid = dnid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPortalNumber() {
		return this.portalNumber;
	}

	public void setPortalNumber(String portalNumber) {
		this.portalNumber = portalNumber;
	}

	

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

}