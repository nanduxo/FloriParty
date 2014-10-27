package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Entidade.Anunciante;
import Util.JpaUtil;

public class AnuncianteDao {
	
	private EntityManager entityManager;
	
	public AnuncianteDao() {
		entityManager = JpaUtil.getEntityManager();
	}
	
	public List<Anunciante> listarAnunciante() {
		Query query = entityManager
				.createQuery("From Anunciante", Anunciante.class);
		return query.getResultList();
	}

	public void salvarEvento(Anunciante anunciante) {
		entityManager.merge(anunciante);
	}

	public Anunciante buscarPorIdEvento(Long id) {
		return entityManager.find(Anunciante.class, id);
	}

	public void excluir(Long id) {
		Anunciante anunciante = entityManager.getReference(Anunciante.class, id);
		entityManager.remove(anunciante);
	}

}
