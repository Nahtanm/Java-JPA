package persistencia.aplicacao.implementacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import persistencia.aplicacao.entidades.Veiculo;
import persistencia.aplicacao.interfaces.VeiculoInterface;

public class VeiculoImplementacao implements VeiculoInterface{
	private Scanner in = new Scanner(System.in);
	private EntityManagerFactory emf =  Persistence.createEntityManagerFactory("persistencia-jpa");
	private EntityManager em = emf.createEntityManager();
	
	public VeiculoImplementacao() {
		
	}
	
	@Override
	public void inserirVeiculo(Veiculo veiculo) {
		
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void detelarVeiculo(Integer id) {
		
		Veiculo veiculo = em.find(Veiculo.class, id);
		
		em.getTransaction().begin();
		em.remove(veiculo);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void atualizarVeiculo(Integer id) {
		
		em.getTransaction().begin();
		Veiculo veiculo = em.find(Veiculo.class, id);
		
		System.out.print("Nome: ");
			String nome = in.next();
		
		if(veiculo != null) {
			veiculo.setModelo(nome);
			veiculo.setId_marca(null);
			veiculo.setId_categoria(null);
			veiculo.setExe_disponiveis(0);
			em.merge(veiculo);
			em.getTransaction().commit();
		}else {
			System.out.println("Veiculo não encontrado");
		}
		em.close();
		emf.close();
		
	}

	@Override
	public Veiculo buscarPorId(Integer id) {
		
		Veiculo veiculo = em.find(Veiculo.class, id);
		if(veiculo != null) {
			em.close();
			emf.close();
			return veiculo;
		}else {
			em.close();
			emf.close();
			return null;
		}
		
	}

	@Override
	public List<Veiculo> buscarTodos() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Veiculo> cq = cb.createQuery(Veiculo.class);
        Root<Veiculo> rootEntry = cq.from(Veiculo.class);
        CriteriaQuery<Veiculo> all = cq.select(rootEntry);
		List<Veiculo> listaVeiculo = em.createQuery(all).getResultList();
		em.close();
		emf.close();
		
		return listaVeiculo;
	}


	
}
