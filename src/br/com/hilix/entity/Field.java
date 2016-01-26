package br.com.hilix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Index;

@Entity(name="fields")
public class Field implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fields", unique = true, nullable = false)
    @Index(name="idx_fields")
	private Long idField;
	
	@Column(name="field_name")
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCanva")
	private Canva canva;
	
}
