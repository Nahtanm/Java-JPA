package persistencia.aplicacao.implementacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import persistencia.aplicacao.entidades.Cliente;
import persistencia.aplicacao.interfaces.ClienteInterface;

public class ClienteImplementacao implements ClienteInterface {
	private Scanner in = new Scanner(System.in);
	private EntityManagerFactory emf =  Persistence.createEntityManagerFactory("persistencia-jpa");
	private EntityManager em = emf.createEntityManager();
	
	public ClienteImplementacao() {
		
	}
	
	@Override
	public void inserirCliente(Cliente cliente) {
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void detelarCliente(Integer id) {
		
		Cliente cliente = em.find(Cliente.class, id);
		
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void atualizarCliente(Integer id) {

		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		
		System.out.print("Nome: ");
			String nome = in.next();
		System.out.print("Email: ");
			String email =in.next();
		System.out.print("CPF: ");
			String cpf = in.next();
		System.out.print("Telefone: ");
			String telefone = in.next();
		
		if(cliente != null) {
			cliente.setNome(nome);
			cliente.setEmail(email);
			cliente.setCpf(cpf);
			cliente.setTelefone(telefone);
			em.merge(cliente);
			em.getTransaction().commit();
		}else {
			System.out.println("Cliente não encontrado");
		}
		em.close();
		emf.close();
		
	}

	@Override
	public Cliente buscarPorId(Integer id) {
		
		Cliente cliente = em.find(Cliente.class, id);
		if(cliente != null) {
			em.close();
			emf.close();
			return cliente;
		}else {
			em.close();
			emf.close();
			return null;
		}
	}

	@Override
	public List<Cliente> buscarTodos() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> rootEntry = cq.from(Cliente.class);
        CriteriaQuery<Cliente> all = cq.select(rootEntry);
		List<Cliente> listaCliente = em.createQuery(all).getResultList();
		em.close();
		emf.close();
		
		return listaCliente;
	}

}
