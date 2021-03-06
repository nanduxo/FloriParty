package ManagedBean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import Util.UploadImageUtil;
import Dao.EventoDao;
import Entidade.Evento;
@SessionScoped
@ManagedBean
public class EventoMb {
	private EventoDao eventoDao;
	private List<Evento> eventos;
	private Evento evento;
	private Part imagem;

	public List<Evento> getEventos() {
		eventoDao = new EventoDao();
		if (eventos == null) {
			eventos = eventoDao.listar();
		}
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Part getImagem() {
		return imagem;
	}

	public void setImagem(Part imagem) {
		this.imagem = imagem;
	}

	@PostConstruct
	public void init() {
		evento = new Evento();
	}

	// ///////////////////////////action/////////////////////////////

	public String caminho(String nomeImagem) {
		return UploadImageUtil.getCaminho(nomeImagem);
	}

	public String salvar() throws IOException {
		eventoDao = new EventoDao();
		String nomeImagem = UploadImageUtil.copiar(imagem,
				evento.getImagem());
		evento.setImagem(nomeImagem);
		
		//salvar
		eventoDao.salvar(getEvento());
		//retornar �..
		return "index";
	}

	public String carregarEdicao(String id) {
		eventoDao = new EventoDao();
		evento = eventoDao.buscarPorId(Long.parseLong(id));
		return "eventoform";
	}

	public String excluir(String id) {
		eventoDao = new EventoDao();
		Evento eventoRemovido = eventoDao.excluir(Long.parseLong(id));

		eventos = null;
		return "eventolista";
	}
}
