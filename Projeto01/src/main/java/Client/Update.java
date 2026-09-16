package Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Objects.Produto;

public class Update {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		String novoNome = "Produto Novo";
		int novaCategoria = 10;
		
		em.getTransaction().begin();
		
		Produto novoP = em.find(Produto.class, 3);
		
		novoP.setNome(novoNome);
		novoP.setCategoria(novaCategoria);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
