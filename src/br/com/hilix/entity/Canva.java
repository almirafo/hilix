package br.com.hilix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Index;

@Entity(name="canvas")
public class Canva implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_canvas", unique = true, nullable = false)
    @Index(name="idx_canvas")
    private Long idCanvas;
    
    @Column(name="name_canvas")
    private String nameCanvas;
    
}
