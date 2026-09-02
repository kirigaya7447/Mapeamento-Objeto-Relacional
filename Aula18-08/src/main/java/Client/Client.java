package Client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Objects.Produto;

public class Client {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Scanner leia = new Scanner(System.in);
		Produto p1 = new Produto("Teste 01", 1);
		Produto p2 = new Produto("Teste 02", 2);
		Produto p3 = new Produto("Teste 03", 3);
		
		
		System.out.println("Digite seu nome: ");
		p1.setNome(leia.nextLine());
		System.out.println("Nome " + p1.getNome() + " salvo com sucesso!");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		leia.close();
		
	}
}
