package persistencia.aplicacao.implementacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import persistencia.aplicacao.entidades.Marca;
import persistencia.aplicacao.interfaces.MarcaInterface;

public class MarcaImplementacao implements MarcaInterface{
	private Scanner in = new Scanner(System.in);
	private EntityManagerFactory emf =  Persistence.createEntityManagerFactory("persistencia-jpa");
	private EntityManager em = emf.createEntityManager();
	
	
	public MarcaImplementacao() {
		
	}
	
	@Override
	public void inserirMarca(Marca marca) {
		
		em.getTransaction().begin();
		em.persist(marca);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void detelarMarca(Integer id) {
		
		Marca marca = em.find(Marca.class, id);
		
		em.getTransaction().begin();
		em.remove(marca);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void atualizarMarca(Integer id) {
		
		em.getTransaction().begin();
		Marca marca = em.find(Marca.class, id);
		
		System.out.print("Nome: ");
			String nome = in.next();
		
		if(marca != null) {
			marca.setMarca(nome);
			em.merge(marca);
			em.getTransaction().commit();
		}else {
			System.out.println("Marca não encontrado");
		}
		em.close();
		emf.close(); 
		
	}

	@Override
	public Marca buscarPorId(Integer id) {
		
		Marca marca = em.find(Marca.class, id);
		if(marca != null) {
			em.close();
			emf.close();
			return marca;
		}else {
			em.close();
			emf.close();
			return null;
		}
		
	}

	@Override
	public List<Marca> buscarTodos() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Marca> cq = cb.createQuery(Marca.class);
        Root<Marca> rootEntry = cq.from(Marca.class);
        CriteriaQuery<Marca> all = cq.select(rootEntry);
		List<Marca> listaMarca = em.createQuery(all).getResultList();
		em.close();
		emf.close();
		
		return listaMarca;
	}



}
