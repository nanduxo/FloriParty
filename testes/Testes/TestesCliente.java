package Testes;

import java.util.List;

import javax.persistence.EntityManager;




import javax.persistence.Query;



import Entidade.Cliente;

import Util.JpaUtil;

public class TestesCliente {

	private static EntityManager entityManager;

	public static void main(String[] args) {
		JpaUtil.iniciarPersistenceUnit();
	

		entityManager = JpaUtil.getEntityManager();
		inserir();
	//	excluir();
		//editar();
	//	listar();
		
		entityManager.close();		
		JpaUtil.fecharPersistenceUnit();
	}

	

	private static void inserir() {
		Cliente cliente = new Cliente();
		cliente.setNome("Evandro");
		cliente.setCpf("12345678910");
		cliente.setEmail("evandro@hotmail.com");		
		cliente.setSenha("1045466");
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
	}
	
	
	//implementar
	/*
	private static void editar() {
		entityManager.getTransaction().begin();
		Cliente clienteEditado = entityManager.find(Cliente.class, 1L);
		clienteEditado.setNome("Frozen");
		clienteEditado.setSenha("1236");
		
		entityManager.merge(clienteEditado);
		entityManager.getTransaction().commit();
		
	}
	
	*/
	
	/*private static void listar() {
		Query query = entityManager.createQuery("From Clientes", Cliente.class);
		List<Cliente> clientes = query.getResultList();
		
		for(Cliente cliente  : clientes){
			System.out.print(" Numero do Cliente: " + cliente.getNome());
			System.out.print(" Nome do Cliente:  " + cliente.getNome());
			System.out.println(" Email:  " +cliente .getEmail());{
				
			}
			}
			*/
				
	}
	



	
		

