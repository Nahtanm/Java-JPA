package persistencia.aplicacao.implementacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import persistencia.aplicacao.entidades.Aluguel;
import persistencia.aplicacao.interfaces.AluguelInterface;

public class AluguelImplementacao implements AluguelInterface{
	private EntityManagerFactory emf =  Persistence.createEntityManagerFactory("persistencia-jpa");
	private EntityManager em = emf.createEntityManager();
	
	@Override
	public void inserirAluguel(Aluguel aluguel) {
		
		em.getTransaction().begin();
		em.persist(aluguel);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void detelarAluguel(Integer id) {
		
		Aluguel aluguel = em.find(Aluguel.class, id);
		
		em.getTransaction().begin();
		em.remove(aluguel);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void atualizarAluguel(Integer id) {
		
		em.getTransaction().begin();
		Aluguel aluguel  = em.find(Aluguel.class, id);
		
		if(aluguel != null) {
			aluguel.setId_cliente(null);
			aluguel.setId_veiculo(null);
			aluguel.setPreco(0);
			aluguel.setDataInicio(null);
			aluguel.setDataFinal(null);
			em.merge(aluguel);
			em.getTransaction().commit();
		}else {
			System.out.println("Cadastro não encontrado");
		}
		em.close();
		emf.close();
		
	}

	@Override
	public Aluguel buscarPorId(Integer id) {
		
		Aluguel aluguel = em.find(Aluguel.class, id);
		if(aluguel != null) {
			em.close();
			emf.close();
			return aluguel;
		}else {
			em.close();
			emf.close();
			return null;
		}
		
	}

	@Override
	public List<Aluguel> buscarTodos() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Aluguel> cq = cb.createQuery(Aluguel.class);
        Root<Aluguel> rootEntry = cq.from(Aluguel.class);
        CriteriaQuery<Aluguel> all = cq.select(rootEntry);
		List<Aluguel> listaAluguel = em.createQuery(all).getResultList();
		em.close();
		emf.close();
		
		return listaAluguel;
	}

	

}
