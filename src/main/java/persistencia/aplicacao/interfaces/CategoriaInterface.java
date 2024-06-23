package persistencia.aplicacao.interfaces;

import java.util.List;

import persistencia.aplicacao.entidades.Categoria;

public interface CategoriaInterface {
	void inserirCategoria(Categoria categoria);
	void detelarCategoria(Integer id);
	void atualizarCategoria(Integer id);
	Categoria buscarPorId(Integer id);
	List<Categoria> buscarTodos();
}
