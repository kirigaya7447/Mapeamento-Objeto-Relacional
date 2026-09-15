package Client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Objects.Produto;

public class SelectComScanner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		Produto x = new Produto();
		
		Scanner leia = new Scanner(System.in);
		
		System.out.println("Digite o ID a ser consultado: ");
		int id = leia.nextInt();
		
		em.getTransaction().begin();
		x = em.find(Produto.class, id);
		
		System.out.println("Nome: " + x.getNome());
		

		leia.close();
	}

}
