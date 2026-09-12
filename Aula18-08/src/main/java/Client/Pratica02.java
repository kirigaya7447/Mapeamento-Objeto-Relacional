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
		int menu = 0;
		int submenu = 0;

		Categoria categ = new Categoria();
		Produto prod = new Produto();

		do {
			System.out.println("//Menu\\\\");
			System.out.println("1 - Para consultar dados");
			System.out.println("2 - Para cadastrar");
			System.out.println("0 - Para sair");
			menu = leia.nextInt();
			leia.nextLine();

			switch (menu) {
			case 0:
				break;

			case 1:
				submenu = subMenu(leia);
				
				if (submenu == 1) {
					int id;

					System.out.println("Digite o ID da categoria: ");
					id = leia.nextInt();

					System.out.println("Busca realizada:");
					consultarCategoria(categ, id);
				} else if (submenu == 2) {
					int id;

					System.out.println("Digite o ID do produto: ");
					id = leia.nextInt();

					System.out.println("Busca realizada:");
					consultarProduto(prod, id);
				}
				break;

			case 2:
				submenu = subMenu(leia);
				
				if (submenu == 1) {
					String descricao;
					String ativo;

					System.out.println("Digite a descrição da categoria: ");
					descricao = leia.nextLine();

					System.out.println("Digite o ativo da categoria: ");
					ativo = leia.nextLine();

					categ = new Categoria(descricao, ativo);

					cadastrarCategoria(categ);

					System.out.println("Categoria cadastrada com sucesso!");
				} else if (submenu == 2) {
					String nome;
					int categoria;

					System.out.println("Digite o nome do produto: ");
					nome = leia.nextLine();

					System.out.println("Digite a categoria do produto: ");
					categoria = leia.nextInt();

					prod = new Produto(nome, categoria);

					cadastrarProduto(prod);

					System.out.println("Produto cadastrado com sucesso!");
				}
				break;
			default:

				break;
			}
		} while (menu != 0);

		System.out.println("Código finalizado!");
		leia.close();

	}

	public static void consultarCategoria(Categoria categ, int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println(em.find(Categoria.class, id));
		em.close();
		emf.close();
	}

	public static void cadastrarCategoria(Categoria categ) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(categ);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void consultarProduto(Produto prod, int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println(em.find(Produto.class, id));
		em.close();
		emf.close();
	}

	public static void cadastrarProduto(Produto prod) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(prod);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static int subMenu(Scanner leia) {
		System.out.println("//Seleção de objetos\\\\");
		System.out.println("1 - Categoria");
		System.out.println("2 - Produto");
		System.out.println("0 - Para voltar ao menu principal");
		int subMenu = leia.nextInt();
		leia.nextLine();
		return subMenu;
	}
}
