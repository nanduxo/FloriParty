package ManagedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import model.Relacionamento;
import Dao.ClienteDao;
import Entidade.Cliente;

@ManagedBean
public class ClienteMb {
	private ClienteDao clienteDao;
	private List<Cliente> clientes;
	private Cliente cliente;
	private static List<Relacionamento> relacionamentos;
	
	//lista
	public List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = clienteDao.listar();
		}
		return clientes;
	}

	
	
	static {
		relacionamentos = new ArrayList<Relacionamento>();
		relacionamentos.add(new Relacionamento(1L,"Aberto(a)"));
		relacionamentos.add(new Relacionamento(2L,"Casado(a)"));
		relacionamentos.add(new Relacionamento(3L,"Solteiro(a)"));
		relacionamentos.add(new Relacionamento(4L,"Viuvo(a)"));
		relacionamentos.add(new Relacionamento(5L,"Pro crime"));
		relacionamentos.add(new Relacionamento(6L,"Querendo"));
		relacionamentos.add(new Relacionamento(7L,"A espera de um Milagre"));
	}
	
	
	
	// getter e setters
	public List<Relacionamento> getRelacionamentos() {
		return relacionamentos;
	}

	public void setRelacionamentos(List<Relacionamento> relacionamentos) {
		this.relacionamentos = relacionamentos;
	}
	
	public void setclientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	//iniciar dao
	@PostConstruct
	public void init() {
		clienteDao = new ClienteDao();
		cliente = new Cliente();
	}

	// ///////////////////////////action/////////////////////////////

	public String salvar() throws IOException {
		clienteDao.salvar(cliente);
		return "clientelista";
	}

	public String carregarEdicao(String id) {
		cliente = clienteDao.buscarPorId(Long.parseLong(id));
		return "clienteform";
	}

	public String excluir(String id) {
		Cliente clienteRemovido = clienteDao.excluir(Long.parseLong(id));

		clientes = null;
		return "clientelista";
	}

	
}
