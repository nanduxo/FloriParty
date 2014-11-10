package ContatoMb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

import Util.UploadImageUtil;
import Dao.AnuncianteDao;
import Entidade.Anunciante;



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
			if (anunciantes== null){
				anunciantes=anuncianteDao.listar();		
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
		public void init(){
			anuncianteDao = new AnuncianteDao();
			anunciante = new Anunciante();
		}
		public Part getLogo() {
			return imagem;
		}

		public void setImagem(Part imagem) {
			this.imagem = imagem;
		}

		
		
/////////////////////////////action/////////////////////////////
		
		
		public String caminho(String nomeImagem){
			return UploadImageUtil.getCaminho(nomeImagem);
		}
		
		public String salvar() throws IOException{
			anuncianteDao.salvar(getAnunciante());
			return "anunciantelista";
		}
		
		public String carregarEdicao(String id){
			anunciante = anuncianteDao.buscarPorId(Long.parseLong(id));
			return "anuncianteform";
		}
		
		public String excluir(String id){
			Anunciante anuncianteRemovido = anuncianteDao.excluir(Long.parseLong(id));
			
			anunciantes = null;
			return "clientelista";
		}
	}
	
	
	
	
	
	