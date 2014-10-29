package Entidade;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//@NamedQuery(name="Cliente.findAll", query="SELECT b FROM cliente b")
public class Anunciante  {
	
	
	


	@Id
	@GeneratedValue
	private Long id;
	// classes do Bancocliente

	private String nome;
	private String email;
	private String descicao;
	private String imagem;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Evento> eventos;

	public List<Evento> getEventos() {
		return eventos;
	}
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	// getter e setters
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





	public String getDescicao() {
		return descicao;
	}





	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}





	public String getImagem() {
		return imagem;
	}





	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	
	}

	

