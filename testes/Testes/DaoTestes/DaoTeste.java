package Testes.DaoTestes;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Util.JpaUtil;

import Dao.AnuncianteDao;
import Dao.ClienteDao;
import Dao.EventoDao;

public class DaoTeste extends TestCase {

	
	
	private static EntityManager entityManager;
	
	@BeforeClass
	public static void init(){
		JpaUtil.iniciarPersistenceUnit();
		entityManager = JpaUtil.createEntityManager();
	}
	
	
	
	@Test
	public void testClienteDao() {
		ClienteDao dao = new ClienteDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Cliente esta nulo", dao);
		dao = null;
	}
	
	@Test
	public void testEventoDao() {
		ClienteDao dao = new ClienteDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Cliente esta nulo", dao);
		dao = null;
	}
	
	@Test
	public void testAnunciante() {
		ClienteDao dao = new ClienteDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Cliente esta nulo", dao);
		dao = null;
	}
	
	@Test
	public void testContatoDao() {
		AnuncianteDao dao = new AnuncianteDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Contato esta nulo", dao);
		dao = null;
	}
	
	@Test
	public void testReservaDao() {
		EventoDao dao = new EventoDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Reserva esta nulo", dao);
		dao = null;
	}
	
	@AfterClass
	public static void close(){
		entityManager.close();
		JpaUtil.fecharPersistenceUnit();
	}
	
	
	
	
	

		
		
		
		
		
		
		
		
		
		
		
		
		
	

	
	
}
