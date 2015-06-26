package br.com.hilix.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class CreateClass {

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FreeCallJPA");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			
			//List<ListaFidelizadaVO> list = new ArrayList();
			
			//list =  em.createNamedQuery("ListaGeral.ListaCustomizada").getResultList();
		
			System.out.println("check");
			
			
			
		/*	Cdr cdr = list.get(0);
			
			String S = new SimpleDateFormat("yyyy-MM-dd").format(cdr.getCallDatetime());
			
			String Y = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
			
			S.equals(Y);
			
			if(cdr.getCallDatetime().equals(new Timestamp(System.currentTimeMillis()))){
				System.out.println("ccc");
			}
			*/
			
			
			//System.out.println(list.get(0));
			
			/*
			SpotTipo spotTipo = new SpotTipo();
			//1	SPOT SIMPLES
			spotTipo = new SpotTipo();
			spotTipo.setCodeSpotTipo(1);
			spotTipo.setNomeSpotTipo("SPOT SIMPLES");
			spotTipo.setSpotAction("1");
			em.persist(spotTipo);
			//2	SPOT INTERATIVO
			spotTipo = new SpotTipo();
			spotTipo.setCodeSpotTipo(2);
			spotTipo.setNomeSpotTipo("SPOT INTERATIVO");
			spotTipo.setSpotAction("2");
			em.persist(spotTipo);
			//3	SPOT ASSINATURA
			spotTipo = new SpotTipo();
			spotTipo.setCodeSpotTipo(3);
			spotTipo.setNomeSpotTipo("SPOT ASSINATURA");
			spotTipo.setSpotAction("3");
			em.persist(spotTipo);
			//4	SPOT SMS
			spotTipo = new SpotTipo();
			spotTipo.setCodeSpotTipo(4);
			spotTipo.setNomeSpotTipo("SPOT SMS");
			spotTipo.setSpotAction("4");
			em.persist(spotTipo);
			//5	SPOT FIDELIZADO
			spotTipo = new SpotTipo();
			spotTipo.setCodeSpotTipo(5);
			spotTipo.setNomeSpotTipo("SPOT FIDELIZADO");
			spotTipo.setSpotAction("5");
			em.persist(spotTipo);
			
			*/
			
			
			
	//		Campanha campanha = list.get(1);
			
	//		Agencia agencia = campanha.getAgencia().get(0);
			
		//	Object l = list.get(0);
			
			//jdbc/FreeCall
			
			
			
	//		UserType user = em.find(UserType.class, 1);

	//		user.setIdUserType(1);

	//		em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			emf.close();
		}

		System.out.println("It is over");
	}

}
