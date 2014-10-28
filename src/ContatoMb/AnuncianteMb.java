package ContatoMb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import Dao.AnuncianteDao;
import Entidade.Anunciante;



	@ManagedBean
	public class AnuncianteMb {
		private AnuncianteDao anuncianteDao;
		
		private List<Anunciante> anunciantes;
		private Anunciante anunciante;


		public List<Anunciante> getAnunciantes() {
			if(anunciante == null){
				anunciantes = anuncianteDao.listarAnunciante();
			}
			return anunciantes;
		}

		public void setanunciantes(List<Anunciante> anunciantes) {
			this.anunciantes = anunciantes;
		}

		public Anunciante getAnunciante() {
			return anunciante;
		}

		public void setEvento(Anunciante anunciante) {
			this.anunciante = anunciante;
		}
		
		
		@PostConstruct
		public void init(){
			anuncianteDao = new AnuncianteDao();
			anunciante = new Anunciante();
		}
		
/////////////////////////////action/////////////////////////////
		
		public String salvar() throws IOException{
			anuncianteDao.salvarAnunciante(getAnunciante());
			return "anunciantelista";
		}
		
		public String carregarEdicao(String id){
			anunciante = anuncianteDao.buscarPorIdAnunciante(Long.parseLong(id));
			return "anuncianteform";
		}
		
		public String excluir(String id){
			Anunciante anuncianteRemovido = anuncianteDao.excluirAnunciante(Long.parseLong(id));
			
			anunciantes = null;
			return "clientelista";
		}
	}
	
	
	
	
	
	