package ManagedBean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import Util.UploadImageUtil;
import Dao.AnuncianteDao;
import Entidade.Anunciante;
@SessionScoped
@ManagedBean
public class AnuncianteMb {
	private AnuncianteDao anuncianteDao;
	private List<Anunciante> anunciantes;
	private Anunciante anunciante;
	private Part imagem;

	public AnuncianteDao getAnuncianteDao() {
		return anuncianteDao;
	}

	public void setAnuncianteDao(AnuncianteDao anuncianteDao) {
		this.anuncianteDao = anuncianteDao;
	}

	public List<Anunciante> getAnunciantes() {
		anuncianteDao = new AnuncianteDao();
		if (anunciantes == null) {
			anunciantes = anuncianteDao.listar();
		}
		return anunciantes;
	}

	public void setAnunciantes(List<Anunciante> anunciantes) {
		this.anunciantes = anunciantes;
	}

	public Anunciante getAnunciante() {
		return anunciante;
	}

	public void setAnunciante(Anunciante anunciante) {
		this.anunciante = anunciante;
	}

	public Part getImagem() {
		return imagem;
	}

	@PostConstruct
	public void init() {
	
		anunciante = new Anunciante();
	}

	public void setImagem(Part imagem) {
		this.imagem = imagem;
	}

	// ///////////////////////////action/////////////////////////////

	public String caminho(String nomeImagem) {
		return UploadImageUtil.getCaminho(nomeImagem);
	}

	public String salvar() throws IOException {
		anuncianteDao = new AnuncianteDao();
		String nomeImagem = UploadImageUtil.copiar(imagem,
				anunciante.getImagem());
		anunciante.setImagem(nomeImagem);
		
		//salvar
		anuncianteDao.salvar(getAnunciante());
		return "/index?faces-redirect=true";
	}

	public String carregarEdicao(String id) {
		anuncianteDao = new AnuncianteDao();
		anunciante = anuncianteDao.buscarPorId(Long.parseLong(id));
		return "anuncianteform";
	}

	public String excluir(String id) {
		anuncianteDao = new AnuncianteDao();
		Anunciante anuncianteRemovido = anuncianteDao.excluir(Long
				.parseLong(id));

		anunciantes = null;
		return "anunciantelista";
	}
}
