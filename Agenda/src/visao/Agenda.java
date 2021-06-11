// Código criado pelo professor Paulo Meirelles da instituição UFABC, durante o curso de POO.
// O código foi refeito para treinamento de Orientação à Objeto.

package visao;

import java.util.Scanner;

import modelo.Pessoa;

public class Agenda {
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		//Objeto 1
		Pessoa contato;
		
		System.out.println("Digite o nome: ");
		contato = new Pessoa(leitor.nextLine());
		
		System.out.println("Digite o telefone: ");
		contato.setTelefone(leitor.nextLine());
		
		System.out.println("Digite o email: ");
		contato.setEmail(leitor.nextLine());
		
		System.out.println(contato.toString());
		
		//Objeto 2
		Pessoa outroContato;
		
		System.out.println("Digite o nome: ");
		outroContato = new Pessoa(leitor.nextLine());
		
		System.out.println("Digite o telefone: ");
		outroContato.setTelefone(leitor.nextLine());
		
		System.out.println("Digite o email: ");
		outroContato.setEmail(leitor.nextLine());
		
		System.out.println(outroContato.toString());
		
		leitor.close();
	}

}