package br.com.hilix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Index;
/**
 * 
 * @author almir
 * S
 *
 */
@Entity(name="group")
public class Group implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group", unique = true, nullable = false)
    @Index(name="idx_group")
    private Long idgroup;
    
    @Column(name="name_group")
    private String nameGroup;
    


}
