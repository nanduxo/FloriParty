package ContatoMb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import Dao.EventoDao;
import Entidade.Evento
;



	@ManagedBean
	public class EventoMb {
		private EventoDao eventoDao;
		
		private List<Evento> eventos;
		private Evento evento;


		public List<Evento> getEventos1() {
			if(evento == null){
				eventos = eventoDao.listarEvento();
			}
			return eventos;
		}

		public void seteventos(List<Evento> eventos) {
			this.eventos = eventos;
		}

		public Evento getEventos() {
			return evento;
		}

		public void setEvento(Evento evento) {
			this.evento = evento;
		}
		
		
		@PostConstruct
		public void init(){
			eventoDao = new EventoDao();
			evento = new Evento(null);
		}
		
/////////////////////////////action/////////////////////////////
		
		public String salvar() throws IOException{
			eventoDao.salvarEvento(getEventos1());
			return "clientelista";
		}
		
		public String carregarEdicao(String id){
			evento = eventoDao.buscarPorIdEvento(Long.parseLong(id));
			return "clienteform";
		}
		
		public String excluir(String id){
			Evento eventoRemovido = eventoDao.excluirEvento(Long.parseLong(id));
			
			eventos = null;
			return "clientelista";
		}
	}
	
	
	
	
	
	