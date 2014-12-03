package ManagedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Relacionamento;
import Dao.ClienteDao;
import Entidade.Cliente;

@SessionScoped
@ManagedBean
public class ClienteMb {
	private ClienteDao clienteDao;
	private List<Cliente> clientes;
	private Cliente cliente;
	private static List<Relacionamento> relacionamentos;
	private Cliente logado;
	private Cliente login;
	
	//lista
	public List<Cliente> getClientes() {
		ClienteDao dao = new ClienteDao();
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

	public boolean islogado() {
		return logado != null;
	}
	
	public Cliente getLogado() {
		return logado;
	}

	public void setLogado(Cliente logado) {
		this.logado = logado;
	}

	public Cliente getLogin() {
		return login;
	}

	public void setLogin(Cliente login) {
		this.login = login;
	}

	//iniciar dao
	@PostConstruct
	public void init() {
		
		cliente = new Cliente();
		login = new Cliente();
	}
	
	

	// ///////////////////////////action/////////////////////////////

	public String salvar() throws IOException {
		clienteDao = new ClienteDao();
		clienteDao.salvar(cliente);
		return "/index?faces-redirect=true";
	}

	public String carregarEdicao(String id) {
		clienteDao = new ClienteDao();
		cliente = clienteDao.buscarPorId(Long.parseLong(id));
		return "clienteform";
	}

	public String excluir(String id) {
		clienteDao = new ClienteDao();
		Cliente clienteRemovido = clienteDao.excluir(Long.parseLong(id));

		clientes = null;
		return "clientelista";
	}

	public String login() {
		if (fazerLogin()) {
			return "index?faces-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário ou senha não confere."));
		return "";
	}
	
	private boolean fazerLogin() {
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.buscarUsuarioPorEmail(login.getEmail());
		
		if (cliente == null)
			return false;
		if (!cliente.getSenha().equals(login.getSenha()))
			return false;
		if (!cliente.getEmail().equalsIgnoreCase(login.getEmail()))
			return false;
		
		logado = cliente;
		return true;
	}

	

	public String logout() {
		logado = null;
		return "index?faces-redirect=true";
	}

	
	
	
}
