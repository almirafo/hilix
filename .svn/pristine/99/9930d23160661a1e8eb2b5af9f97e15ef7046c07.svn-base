package com.supportcomm.ocp.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="companyListAll" ,query="Select l from Company l"),
	@NamedQuery(name="getCompany" ,query="Select l from Company l where l.companyId= :companyId")
})
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_id")
	private Long companyId;

	private String name;



	public Company() {
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



	

}