package persistencia.aplicacao.interfaces;

import persistencia.aplicacao.implementacao.AluguelImplementacao;
import persistencia.aplicacao.implementacao.CategoriaImplementacao;
import persistencia.aplicacao.implementacao.ClienteImplementacao;
import persistencia.aplicacao.implementacao.MarcaImplementacao;
import persistencia.aplicacao.implementacao.VeiculoImplementacao;

public class Criacao {
	
	public static AluguelImplementacao CriarAluguel() {
		return new AluguelImplementacao();
	}
	
	public static CategoriaImplementacao CriarCategoria() {
		return new CategoriaImplementacao();
	}
	
	public static ClienteImplementacao CriarCliente() {
		return new ClienteImplementacao();
	}
	
	public static MarcaImplementacao CriarMarca() {
		return new MarcaImplementacao();
	}
	
	public static VeiculoImplementacao CriarVeiculo() {
		return new VeiculoImplementacao();
	}
	
	
}
