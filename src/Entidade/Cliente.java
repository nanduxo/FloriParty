package Entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
// @NamedQuery(name="Cliente.findAll", query="SELECT b FROM cliente b")
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;
	// classes do Bancocliente

	private String nome;

	@Column(unique = true,length=11)
	private String cpf;

	@Column(unique = true, nullable = false,length=30)
	private String email;

	@Column(nullable = false,length=30)
	private String senha;
	
	private String sexo;
	
	private Integer relacionamento;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Evento> Eventos;

	public Integer getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(Integer relacionamento) {
		this.relacionamento = relacionamento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

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
