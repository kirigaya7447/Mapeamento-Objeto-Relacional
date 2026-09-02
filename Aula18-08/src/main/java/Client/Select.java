package Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Objects.Produto;

public class Select {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		Produto x = new Produto();

		em.getTransaction().begin();
		System.out.println(em.find(Produto.class, 1));
		em.close();
		emf.close();
		
		x = em.find(Produto.class, 1);
	}

}
