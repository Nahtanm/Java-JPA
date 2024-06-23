package persistencia.aplicacao.implementacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import persistencia.aplicacao.entidades.Categoria;
import persistencia.aplicacao.interfaces.CategoriaInterface;

public class CategoriaImplementacao implements CategoriaInterface {
	private Scanner in = new Scanner(System.in);
	private EntityManagerFactory emf =  Persistence.createEntityManagerFactory("persistencia-jpa");
	private EntityManager em = emf.createEntityManager();
	
	
	public CategoriaImplementacao() {
		
	}
	
	@Override
	public void inserirCategoria(Categoria categoria) {
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void detelarCategoria(Integer id) {
		
		Categoria categoria = em.find(Categoria.class, id);
		
		em.getTransaction().begin();
		em.remove(categoria);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void atualizarCategoria(Integer id) {
		
		em.getTransaction().begin();
		Categoria categoria = em.find(Categoria.class, id);
		
		System.out.print("Nome: ");
			String nome = in.next();
			
		if(categoria != null) {
			categoria.setCategoria(nome);
			em.merge(categoria);
			em.getTransaction().commit();
		}else {
			System.out.println("Categoria não encontrado");
		}
		em.close();
		emf.close();
		
	}

	@Override
	public Categoria buscarPorId(Integer id) {
		
		Categoria categoria = em.find(Categoria.class, id);
		if(categoria != null) {
			em.close();
			emf.close();
			return categoria;
		}else {
			em.close();
			emf.close();
			return null;
		}
		
	}

	@Override
	public List<Categoria> buscarTodos() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Categoria> cq = cb.createQuery(Categoria.class);
        Root<Categoria> rootEntry = cq.from(Categoria.class);
        CriteriaQuery<Categoria> all = cq.select(rootEntry);
		List<Categoria> listaCategorias = em.createQuery(all).getResultList();
		em.close();
		emf.close();
		
		return listaCategorias;
	}

	
}
