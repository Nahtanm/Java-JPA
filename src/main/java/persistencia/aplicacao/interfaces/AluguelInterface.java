package persistencia.aplicacao.interfaces;

import java.util.List;

import persistencia.aplicacao.entidades.Aluguel;

public interface AluguelInterface {
	void inserirAluguel(Aluguel aluguel);
	void detelarAluguel(Integer id);
	void atualizarAluguel(Integer id);
	Aluguel buscarPorId(Integer id);
	List<Aluguel> buscarTodos();
}
