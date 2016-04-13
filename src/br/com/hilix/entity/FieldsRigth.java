package br.com.hilix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Index;

@Entity(name="fields_rigth")
public class FieldsRigth implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8903577236921033114L;

	public Field field;
	
	public int accessType;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fieldsrigth", unique = true, nullable = false)
    @Index(name="idx_fields")
	private Long idFieldRigth;
	
	public Long getIdFieldRigth() {
		return idFieldRigth;
	}

	public void setIdFieldRigth(Long idFieldRigth) {
		this.idFieldRigth = idFieldRigth;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public int getAccessType() {
		return accessType;
	}

	public void setAccessType(int accessType) {
		this.accessType = accessType;
	}



}
