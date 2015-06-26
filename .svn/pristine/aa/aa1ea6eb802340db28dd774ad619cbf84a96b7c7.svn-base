package com.supportcomm.ocp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the site database table.
 * 
 */
@Entity
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="site_id")
	private Long siteId;

	private String description;

	private String name;

	//bi-directional many-to-one association to Ivr
	@OneToMany(mappedBy="site")
	private List<Ivr> ivrs;

	//bi-directional many-to-one association to Portal
	@OneToMany(mappedBy="site")
	private List<Portal> portals;

	public Site() {
	}

	public Long getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ivr> getIvrs() {
		return this.ivrs;
	}

	public void setIvrs(List<Ivr> ivrs) {
		this.ivrs = ivrs;
	}

	public Ivr addIvr(Ivr ivr) {
		getIvrs().add(ivr);
		ivr.setSite(this);

		return ivr;
	}

	public Ivr removeIvr(Ivr ivr) {
		getIvrs().remove(ivr);
		ivr.setSite(null);

		return ivr;
	}

	public List<Portal> getPortals() {
		return this.portals;
	}

	public void setPortals(List<Portal> portals) {
		this.portals = portals;
	}

	public Portal addPortal(Portal portal) {
		getPortals().add(portal);
		portal.setSite(this);

		return portal;
	}

	public Portal removePortal(Portal portal) {
		getPortals().remove(portal);
		portal.setSite(null);

		return portal;
	}

}