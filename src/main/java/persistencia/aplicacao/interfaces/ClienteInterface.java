package persistencia.aplicacao.interfaces;

import java.util.List;

import persistencia.aplicacao.entidades.Cliente;

public interface ClienteInterface {
	void inserirCliente(Cliente cliente);
	void detelarCliente(Integer id);
	void atualizarCliente(Integer id);
	Cliente buscarPorId(Integer id);
	List<Cliente> buscarTodos();
}
