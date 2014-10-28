package Entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Evento {

	@Id
	@GeneratedValue
	private Long id;

	private String nomeevento;
	private String data;
	private String local;
	private String traje;
	private int valor;
	private String atracao;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cliente cliente;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "eventos")
	private List<Cliente> Clientes;

	public Evento(EntityManager entityManager) {
		// TODO Auto-generated constructor stub
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {		
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeevento() {
		return nomeevento;
	}

	public void setNomeevento(String nomeevento) {
		this.nomeevento = nomeevento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTraje() {
		return traje;
	}

	public void setTraje(String traje) {
		this.traje = traje;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getAtracao() {
		return atracao;
	}

	public void setAtracao(String atracao) {
		this.atracao = atracao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCanal(Cliente cliente) {
		this.cliente = cliente;
	}

}
