package Entidade;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//@NamedQuery(name="Cliente.findAll", query="SELECT b FROM cliente b")
public class Cliente  {
	
	
	


	@Id
	@GeneratedValue
	private Long id;
	// classes do Bancocliente

	private String nome;
	private String cpf;
	private String email;
	private String senha;

	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Evento> Eventos;

	
	
	
	

	
	// getter e setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public List<Evento> getEventos() {
		return Eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.Eventos = eventos;
	}

	
	
	
	
	}

	

