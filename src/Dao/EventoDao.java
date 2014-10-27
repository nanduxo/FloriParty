package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Entidade.Evento;
import Util.JpaUtil;

public class EventoDao {
	
	private EntityManager entityManager;
	
	public EventoDao() {
		entityManager = JpaUtil.getEntityManager();
	}
	
	public List<Evento> listarEvento() {
		Query query = entityManager
				.createQuery("From Evento", Evento.class);
		return query.getResultList();
	}

	public void salvarEvento(Evento evento) {
		entityManager.merge(evento);
	}

	public Evento buscarPorIdEvento(Long id) {
		return entityManager.find(Evento.class, id);
	}

	public void excluir(Long id) {
		Evento evento = entityManager.getReference(Evento.class, id);
		entityManager.remove(evento);
	}

}
