package ManagedBean;

import javax.faces.bean.ManagedBean;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import Util.EmailUtil;

@ManagedBean
public class ContatoMb {
	private String nome;
	private String email;
	private String senha;
	private Boolean news;
	private Integer area;
	private String mensagem;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Boolean getNews() {
		return news;
	}
	public void setNews(Boolean news) {
		this.news = news;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String enviar(){
		String mensagemText = "Nome: " + nome +
				"\nEmail: " + email +
				"\nSenha: " + senha +
				"\n¡rea: " + area +
				"\nMensagem: " + mensagem +
				"\nNews: " + news;
		
		try {
			EmailUtil.enviarEmail(email, "Contato via site.", mensagemText);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
