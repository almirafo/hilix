package com.supportcomm.ocp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="loginListAll" ,query="select l from Login l"),
	@NamedQuery(name="getlogin" ,query="Select l from Login l where l.email= :email and l.password = :password"),
	@NamedQuery(name="loginFindEmail" ,query="Select l from Login l where l.email= :email"),
	
}
)




@NamedNativeQueries({
	@NamedNativeQuery(name="loginInsert", query ="INSERT INTO login( " +
                                                 " company_id, username, email, password, description," + 
                                                 " user_level) " +
                                                 " VALUES (:companyId, :username, :email, :password, :description," + 
                                                 ":userLevel)" )

})


public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="login_id")
	private Long loginId;

	private String description;

	private String email;

	private String password;

	private String username;
	
	@Column(name="user_level")
	private String userLevel;

	//bi-directional many-to-one association to Company
	@ManyToOne( cascade= CascadeType.ALL)
	@JoinColumn(name="company_id")
	private Company company;



	public Login() {
	}

	public Long getLoginId() {
		return this.loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	
	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	
}