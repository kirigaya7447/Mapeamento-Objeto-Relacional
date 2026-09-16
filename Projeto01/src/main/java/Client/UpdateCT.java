package Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Objects.Produto;

public class UpdateCT {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		String novoNome = "Produto Novo";
		int novaCategoria = 10;

		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();

			Produto novoP = em.find(Produto.class, 3);

			if (novoP == null) {
				throw new RuntimeException("Produto não encontrado!");

			}

			novoP.setNome(novoNome);
			novoP.setCategoria(novaCategoria);

			tx.commit();

		} catch (RuntimeException err) {
			System.err.println("Erro inicial: " + err);

			if (tx.isActive()) {
				tx.rollback();
			}
			throw err;
		} finally {
			em.close();
		}

		emf.close();
	}
}
