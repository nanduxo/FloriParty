package ContatoMb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import Dao.ClienteDao;
import Entidade.Cliente;

@ManagedBean
public class ClienteMb {
	private ClienteDao clienteDao;
	private List<Cliente> clientes;
	private Cliente cliente;

	public List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = clienteDao.listar();
		}
		return clientes;
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

	@PostConstruct
	public void init() {
		clienteDao = new ClienteDao();
		cliente = new Cliente();
	}

	// ///////////////////////////action/////////////////////////////

	public String salvar() throws IOException {
		clienteDao.salvar(getCliente());
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
