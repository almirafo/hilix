package br;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

@ManagedBean
public class ConsultTesteMB implements Serializable{

	public ConsultTesteMB() {

	}

	public void testeConsult(ActionEvent event) {

		ConectTesteJPA c = new ConectTesteJPA();
		EntityManager em = c.getConect();

		em.getTransaction().begin();

		List list = new ArrayList();

		list = em.createNamedQuery("listaLogin").getResultList();

		System.out.println("oi");

	}

}
