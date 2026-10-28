package Client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Objects.Departamento;
import Objects.Funcionario;

public class Persistencia {

    public static void main(String args[]) {

        Scanner leia = new Scanner(System.in);

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("pratica04");

        EntityManager em = emf.createEntityManager();

        try {

            System.out.println("Pretende criar um novo departamento?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("Opção: ");

            int opcao1 = leia.nextInt();
            leia.nextLine();

            if (opcao1 == 1) {

                System.out.print("Digite o nome do departamento:");
                String nomeDepart = leia.nextLine();

                Departamento departamento = new Departamento(nomeDepart);

                System.out.print("Digite o nome do funcionário: ");
                String nomeFunc= leia.nextLine();

                Funcionario funcionario = new Funcionario(nomeFunc, departamento);
                
                // Mantém o relacionamento entre departamento e funcionários.
                departamento.addFuncionario(funcionario);

                // Inicia a transação.
                em.getTransaction().begin();

                // Persiste os departamentos.
                em.persist(departamento);

                // Persiste os funcionários.
                em.persist(funcionario);

                // Confirma todas as operações.
                em.getTransaction().commit();

                System.out.println("\nDados persistidos com sucesso!");

                System.out.println("\nDepartamentos cadastrados:");
                System.out.println(departamentoTI);
                System.out.println(departamentoRH);

                System.out.println("Funcionários cadastrados:");
                System.out.println(funcionario1);
                System.out.println(funcionario2);
                System.out.println(funcionario3);
                System.out.println(funcionario4);

            } else if (opcao1 == 2) {

                System.out.println("Operação cancelada.");

            } else {

                System.out.println("Opção desconhecida!");

            }

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.err.println("Erro ao persistir os dados:");
            e.printStackTrace();

        } finally {

            em.close();
            emf.close();
            leia.close();

        }
    }
}