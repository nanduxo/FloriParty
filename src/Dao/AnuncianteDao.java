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
	
	public AnuncianteDao(EntityManager entityManager2) {
		// TODO Auto-generated constructor stub
	}

	public List<Anunciante> listarAnunciante() {
		Query query = entityManager
				.createQuery("From Anunciante", Anunciante.class);
		return query.getResultList();
	}

	public void salvarAnunciante(Anunciante anunciante) {
		entityManager.merge(anunciante);
	}

	public Anunciante buscarPorIdAnunciante(Long id) {
		return entityManager.find(Anunciante.class, id);
	}

	public Anunciante excluirAnunciante(Long id) {
		Anunciante anunciante = entityManager.getReference(Anunciante.class, id);
		entityManager.remove(anunciante);
		return anunciante;
	}

}
