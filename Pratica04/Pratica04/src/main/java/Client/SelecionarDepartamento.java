package Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Objects.Departamento;
import Objects.Funcionario;

import java.util.Scanner;

public class SelecionarDepartamento {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pratica04");

		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		System.out.println("Digite o id do funcionário: ");
		int idFunc = leia.nextInt();
		leia.nextLine();
		
		try {
		
		tx.begin();
		
		Funcionario func = em.find(Funcionario.class, idFunc);
		
		if(func == null) {
			throw new RuntimeException("Funcionario não encontrado!");
		}
		
		Departamento depart = func.getDepartamento();
		
		System.out.println("Funcionário " + func.getNome() + " pertence ao departamento " + depart.getNome());
		
		} catch(RuntimeException err) {
			System.err.println("Erro apresentado: " + err.getMessage());
		}
		finally{
			em.close();
		}
		
		emf.close();
		leia.close();

	}

}
