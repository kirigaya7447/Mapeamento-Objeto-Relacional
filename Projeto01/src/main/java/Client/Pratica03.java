package Client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Objects.Categoria;
import Objects.Produto;

public class Pratica03 {
	public static void main(String args[]) {
		Scanner leia = new Scanner(System.in);
		int menu = 0;
		int subMenu = 0;

		Categoria categ = new Categoria();
		Produto prod = new Produto();

		do {
			System.out.println("//Menu\\\\");
			System.out.println("1 - Para consultar dados");
			System.out.println("2 - Para cadastrar");
			System.out.println("3 - Para atualizar");
			System.out.println("0 - Para sair");
			menu = leia.nextInt();
			leia.nextLine();

			switch (menu) {
			case 0:
				break;

			case 1:
				subMenu = subMenu(leia);

				if (subMenu == 1) {
					int id;

					System.out.println("Digite o ID da categoria: ");
					id = leia.nextInt();

					System.out.println("Busca realizada:");
					consultarCategoria(categ, id);
				} else if (subMenu == 2) {
					int id;

					System.out.println("Digite o ID do produto: ");
					id = leia.nextInt();

					System.out.println("Busca realizada:");
					consultarProduto(prod, id);
				}
				break;

			case 2:
				subMenu = subMenu(leia);

				if (subMenu == 1) {
					String descricao;
					String ativo;

					System.out.println("Digite a descrição da categoria: ");
					descricao = leia.nextLine();

					System.out.println("Digite o ativo da categoria: ");
					ativo = leia.nextLine();

					categ = new Categoria(descricao, ativo);

					cadastrarCategoria(categ);

					System.out.println("Categoria cadastrada com sucesso!");
				} else if (subMenu == 2) {
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
			case 3:
				subMenu = subMenu(leia);

				if (subMenu == 1) {
					int id;
					String descricao;
					String ativo;
					
					System.out.println("Digite o ID da categoria a ser alterada: ");
					id = leia.nextInt();
					leia.nextLine();
					
					consultarCategoria(categ, id);

					System.out.println("Digite a nova descrição da categoria: ");
					descricao = leia.nextLine();

					System.out.println("Digite o novo ativo da categoria: ");
					ativo = leia.nextLine();

					atualizarCategoria(categ, id, descricao, ativo);
					System.out.println("Situação final: ");
					consultarCategoria(categ, id);

				} else if (subMenu == 2) {
					int id;
					String nome;
					int categoria;
					
					System.out.println("Digite o ID do produto a ser alterado: ");
					id = leia.nextInt();
					leia.nextLine();
					
					consultarProduto(prod, id);

					System.out.println("Digite o novo nome do produto: ");
					nome = leia.nextLine();

					System.out.println("Digite a nova categoria do produto: ");
					categoria = leia.nextInt();
					leia.nextLine();

					atualizarProduto(prod, id, nome, categoria);
					
					System.out.println("Situação final: ");
					consultarProduto(prod, id);
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

		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();

			categ = em.find(Categoria.class, id);

			if (categ == null) {
				throw new RuntimeException("Categoria não localizada!");
			} else {
				System.out.println(categ);
			}

		} catch (RuntimeException err) {

			System.err.println("Erro em consultarCategoria encontrado: " + err);
		} finally {
			em.close();
		}

		emf.close();
	}

	public static void cadastrarCategoria(Categoria categ) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();

			em.persist(categ);
			tx.commit();

		} catch (RuntimeException err) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw err;

		} finally {
			em.close();
		}
		emf.close();
	}
	
	public static void atualizarCategoria(Categoria categ, int id, String novaDescricao, String novoAtivo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();
			
			categ = em.find(Categoria.class, id);
			
			categ.setDescricao(novaDescricao);
			categ.setAtivo(novoAtivo);

			tx.commit();

		} catch (RuntimeException err) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw err;

		} finally {
			em.close();
		}
		emf.close();
	}

	public static void consultarProduto(Produto prod, int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			prod = em.find(Produto.class, id);

			if (prod == null) {
				throw new RuntimeException("Produto não localizado!");
			} else {
				System.out.println(prod);
			}
		} catch (RuntimeException err) {
			System.err.println("Erro em consultarProduto encontrado: " + err);

		} finally {
			em.close();
		}
		emf.close();
	}

	public static void cadastrarProduto(Produto prod) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();

			em.persist(prod);
			tx.commit();

		} catch (RuntimeException err) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw err;
		} finally {

			em.close();
		}
		emf.close();
	}
	
	public static void atualizarProduto(Produto prod, int id, String novoNome, int novaCategoria) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();
			
			prod = em.find(Produto.class, id);
			
			prod.setNome(novoNome);
			prod.setCategoria(novaCategoria);

			tx.commit();

		} catch (RuntimeException err) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw err;

		} finally {
			em.close();
		}
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
