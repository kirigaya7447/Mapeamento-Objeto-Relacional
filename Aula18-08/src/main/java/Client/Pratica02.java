package Client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Objects.Categoria;
import Objects.Produto;

public class Pratica02 {
	public static void main(String args[]) {
		Scanner leia = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		int menu = 0;
		
		do {
			System.out.println("//Menu\\\\");
			System.out.println("1 - Para consultar dados");
			System.out.println("2 - Para cadastrar");
			System.out.println("0 - Para sair");
			menu = leia.nextInt();
			
			if(menu == 1) {
				System.out.println("Digite a descrição da categoria: ");
				System.out.println("Digite o ativo da categoria: ");
				consultar(emf, em);
			}
			else if(menu == 2) {
				cadastrar(emf, em);
			}
		} while(menu != 0);
		

		System.out.println("Código finalizado!");
		leia.close();
		
		
		
	}
	
	public static void consultar(EntityManagerFactory emf, EntityManager em, Categoria categ) {
		em.getTransaction().begin();
		System.out.println(em.find(Categoria.class, 1));
		em.close();
		emf.close();
	}
	
	public static void cadastrar(EntityManagerFactory emf, EntityManager em, Categoria categ) {
		em.getTransaction().begin();
		em.persist(categ);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
