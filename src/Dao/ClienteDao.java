package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import Util.JpaUtil;
import javax.persistence.Query;
import Entidade.Cliente;

public class ClienteDao {
	
	private EntityManager entityManager;

	public ClienteDao() {
		entityManager = JpaUtil.getEntityManager();
	}
	
	

	



	public List<Cliente> listar() {
		Query query = entityManager
				.createQuery("From Cliente", Cliente.class);
		return query.getResultList();
	}

	public void salvar(Cliente cliente) {
		entityManager.merge(cliente);
	}

	public Cliente buscarPorId(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	public Cliente excluir(Long id) {
		Cliente cliente = entityManager.getReference(Cliente.class, id);
		entityManager.remove(cliente);
		return cliente;
	}

}
