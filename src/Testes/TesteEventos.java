package Testes;

import java.util.List;

import javax.persistence.EntityManager;


import javax.persistence.Query;



import Entidade.Evento;
import Util.JpaUtil;

public class TesteEventos {

	private static EntityManager entityManager;

	public static void main(String[] args) {
		JpaUtil.iniciarPersistenceUnit();
	

		entityManager = JpaUtil.getEntityManager();
		inserir();
 	//excluir();
		listar();
		
		entityManager.close();		
		JpaUtil.fecharPersistenceUnit();
	}

	

	private static void inserir() {
		Evento eventos = new Evento(entityManager);
		eventos.setNome("XXX Pirocada");
		eventos.setTraje("casual");
		eventos.setValor(35);
		eventos.setAtracao("Os Mulekes");		
		eventos.setData("25/01/14");
		eventos.setLocal("Rua do Prazer");
		entityManager.getTransaction().begin();
		entityManager.persist(eventos);
		entityManager.getTransaction().commit();
	}
	
	
	//fase de teste
	
	/*private static void excluir() {
		entityManager.getTransaction().begin();
		Eventos eventos = entityManager.find(Eventos.class, 1L);
		entityManager.remove(eventos);
		entityManager.getTransaction().commit();
	}
	*/
	
	private static void listar() {
		Query query = entityManager.createQuery("From Eventos", Evento.class);
		List<Evento> eventos1 = query.getResultList();
		
		for(Evento eventos : eventos1){
			System.out.print(" Numero do Evento: " + eventos.getNumero());
			System.out.print(" Nome do evento:  " + eventos.getNomeevento());
			System.out.println(" Data:  " + eventos.getData());
			}
		}
	



}




