package Testes;

import java.io.File;
import java.io.FileInputStream;

import javax.persistence.EntityManager;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import Util.JpaUtil;

import Dao.ClienteDao;



	
public class DBunitTest<teste> extends DBTestCase  {


	
		
		private EntityManager entityManager;
		public teste testes;
		
		public DBunitTest() {
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,"jdbc:mysql://localhost:3306/floriparty");
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
			System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
		}

		@Override
		protected IDataSet getDataSet() throws Exception {
			return new FlatXmlDataSetBuilder().build(
					new FileInputStream(new File("input/dbZerado.xml")));
		}
		
		@Override
		protected DatabaseOperation getSetUpOperation() throws Exception {
			return DatabaseOperation.DELETE_ALL;
		}
		
		@Override
		protected DatabaseOperation getTearDownOperation() throws Exception {
			return DatabaseOperation.DELETE_ALL;
		}
		
		public void begin(){
			JpaUtil.iniciarPersistenceUnit();
			entityManager = JpaUtil.getEntityManager();
			entityManager.getTransaction().begin();
			testes = (teste) new ClienteDao(entityManager);
		}
		
		public void close(){
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManager = null;
			testes = null;
			JpaUtil.fecharPersistenceUnit();
		}
		
	

}

