package Entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Evento {

	@Id
	@GeneratedValue
	private Long id;
	
	//
	@Column(unique=true,nullable=false)
	private String nome;
	private String data;
	private String local;
	private String traje;
	private float valor;
	private String atracao;
	private String imagem;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cliente cliente;
	


	

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {		
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
