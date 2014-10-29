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
	
	public List<Evento> listar() {
		Query query = entityManager
				.createQuery("From Evento", Evento.class);
		return query.getResultList();
	}

	public void salvar(List<Evento> list) {
		entityManager.merge(list);
	}

	public Evento buscarPorId(Long id) {
		return entityManager.find(Evento.class, id);
	}

	public Evento excluir(Long id) {
		Evento evento = entityManager.getReference(Evento.class, id);
		entityManager.remove(evento);
		return evento;
	}

}
