package Client;

import java.util.Scanner;
import Objects.Produto;

public class Client {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		Produto p1 = new Produto(1, "Teste 01", 1);
		Produto p2 = new Produto(2, "Teste 02", 2);
		Produto p3 = new Produto(3, "Teste 03", 3);
		
		
		System.out.println("Digite seu nome: ");
		p1.setNome(leia.nextLine());
		System.out.println("Nome " + p1.getNome() + " salvo com sucesso!");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
	}
}
