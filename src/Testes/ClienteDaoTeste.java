package Testes;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import Entidade.Cliente;

public class ClienteDaoTeste extends DBunitTestCliente {


		public  ClienteDaoTeste() {
			
			super();
		}
		
		private void gravacliente(){
			Cliente c = new Cliente();
			c.setNome("pottassius");
			c.setEmail("teste@teste");
			c.setSenha("1654");
			c.setCpf("65456");
			
			
			
		}
		
		@Test
		public void testClienteDao() throws SQLException, Exception{

			begin();
			gravacliente();
			close();
			
			//Carregamento do estado atual do banco de dados.
			IDataSet dataBase = getConnection().createDataSet();
			ITable tabelaAtual = dataBase.getTable("cliente");
			
			//Carregamento do arquivo de controle (Cliente.xml)
			IDataSet dataBaseXML = new FlatXmlDataSetBuilder().build(
					new FileInputStream(new File("control/cliente.xml")));
			ITable tabelaControle = dataBaseXML.getTable("cliente");
			
			Assertion.assertEquals(tabelaControle, tabelaAtual);
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	

	
	
}
