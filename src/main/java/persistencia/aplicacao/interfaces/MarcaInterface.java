package persistencia.aplicacao.interfaces;

import java.util.List;

import persistencia.aplicacao.entidades.Marca;

public interface MarcaInterface {
	void inserirMarca(Marca marca);
	void detelarMarca(Integer id);
	void atualizarMarca(Integer id);
	Marca buscarPorId(Integer id);
	List<Marca> buscarTodos();
}
