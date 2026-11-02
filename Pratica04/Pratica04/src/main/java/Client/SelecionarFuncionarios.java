package Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Objects.Departamento;
import Objects.Funcionario;

import java.util.List;
import java.util.Scanner;

public class SelecionarFuncionarios {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("pratica04");

        EntityManager em = emf.createEntityManager();

        try {

            System.out.println("O que deseja consultar?");
            System.out.println("1 - Funcionários de um departamento");
            System.out.println("2 - Um funcionário e o seu departamento");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());
 
            if (opcao == 1) {

            System.out.print("Digite o ID do departamento: ");
            int idDepartamento = Integer.parseInt(scanner.nextLine());

            Departamento departamento =
                    em.find(Departamento.class, idDepartamento);

            if (departamento == null) {
                System.out.println("Departamento não encontrado.");
                return;
            }

            List<Funcionario> funcionarios = em.createQuery(
                    "SELECT f FROM Funcionario f "
                    + "WHERE f.departamento.id = :id",
                    Funcionario.class)
                    .setParameter("id", idDepartamento)
                    .getResultList();

            System.out.println(
                    "Departamento: " + departamento.getNome());

            if (funcionarios.isEmpty()) {
                System.out.println(
                        "Nenhum funcionário cadastrado neste departamento.");
            } else {
                System.out.println("Funcionários:");

                for (Funcionario funcionario : funcionarios) {
                    System.out.println(
                            funcionario.getId() + " - "
                            + funcionario.getNome());
                }
            }

        }else if (opcao == 2) {
 
                System.out.print("Digite o ID do funcionário: ");
                int idFuncionario = Integer.parseInt(scanner.nextLine());
 
                Funcionario funcionario =
                        em.find(Funcionario.class, idFuncionario);
 
                if (funcionario == null) {
                    System.out.println("Funcionário não encontrado.");
                    return;
                }
 
                System.out.println(
                        "Funcionário: " + funcionario.getId() + " - "
                        + funcionario.getNome());
                System.out.println(
                        "Departamento: "
                        + funcionario.getDepartamento().getId() + " - "
                        + funcionario.getDepartamento().getNome());
 
            } else {
                System.out.println("Opção desconhecida!");
            }    

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            em.close();
            emf.close();
            scanner.close();
        }
    }
}