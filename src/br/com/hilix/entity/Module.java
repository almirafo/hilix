package br.com.hilix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Index;

@Entity(name="module")
public class Module implements  Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_module", unique = true, nullable = false)
    @Index(name="idx_module")
    private Long idmodule;
	
	private String nameModule;

	public Long getIdmodule() {
		return idmodule;
	}

	public void setIdmodule(Long idmodule) {
		this.idmodule = idmodule;
	}

	public String getNameModule() {
		return nameModule;
	}

	public void setNameModule(String nameModule) {
		this.nameModule = nameModule;
	}
	
}
