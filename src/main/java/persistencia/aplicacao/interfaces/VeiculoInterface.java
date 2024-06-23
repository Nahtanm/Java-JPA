package persistencia.aplicacao.interfaces;

import java.util.List;

import persistencia.aplicacao.entidades.Veiculo;

public interface VeiculoInterface {
	void inserirVeiculo(Veiculo veiculo);
	void detelarVeiculo(Integer id);
	void atualizarVeiculo(Integer id);
	Veiculo buscarPorId(Integer id);
	List<Veiculo> buscarTodos();
}
