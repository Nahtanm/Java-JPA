package persistencia.aplicacao.controles;

import persistencia.aplicacao.interfaces.ClienteInterface;
import persistencia.aplicacao.interfaces.Criacao;

public class ClienteControle {
	
	public ClienteControle() {
		ClienteInterface cliente = Criacao.CriarCliente();
	}
	
	public static void menuCliente() {
		
	}
	
}
