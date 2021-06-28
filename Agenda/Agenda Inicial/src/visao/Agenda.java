package visao;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Pessoa;

public class Agenda {

	public static void main(String[] args) {
		ArrayList<Pessoa> meusContatos = new ArrayList<Pessoa>();

		Scanner entrada = new Scanner(System.in);
		int opcao = -1;
		
		String nome;
		
		while (opcao !=0) {
			System.out.println("Digite uma opção:");
			System.out.println("1- Adicionar contato");
			System.out.println("2- Buscar contato");
			System.out.println("3- Atualizar contato");
			System.out.println("4- Remover contato");
			System.out.println("5- Listar todos os contatos");
			System.out.println("0- Sair");
			System.out.println("----------------");

			opcao = Integer.parseInt(entrada.nextLine());

			switch (opcao) {
				case 1: {
					
					adicionarContato(meusContatos);
					
					break;
				}
				case 2: {
					
					System.out.println("Digite o nome do contato:");
					nome = entrada.nextLine();
					
					buscarContato(nome, meusContatos);

					break;
				}
				case 3: {
					
					System.out.println("\nDigite o nome do contato que será atualizado:");
					nome = entrada.nextLine();
					
					atualizarContato(nome, meusContatos);
					break;
				}
				case 4: {
					
					System.out.println("Digite o nome do contato que será removido:");
					nome = entrada.nextLine();
					
					removerContato(nome, meusContatos);
					
					break;
				}
				case 5: {
					
					listarContatos(meusContatos);
					
					break;
				}
				case 0: {
					System.out.println("Obrigado por usar a Agenda.");
					System.exit(opcao);
				}
				default:{
					System.out.println("Opção " + opcao + " inválida.");
					break;
				}
			}
		}
		entrada.close();
	}
	
	public static void adicionarContato(ArrayList<Pessoa> meusContatos) {
		
		Pessoa contato;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o nome:");
		contato = new Pessoa (scan.nextLine());
		
		System.out.println("Digite o sobrenome:");
		contato.setSobrenome(scan.nextLine());

		System.out.println("Digite o telefone:");
		contato.setTelefone(scan.nextLine());

		System.out.println("Digite o email:");
		contato.setEmail(scan.nextLine());
		
		System.out.println("Digite a profissão:");
		contato.setProfissao(scan.nextLine());

		System.out.println("----------------");
		System.out.println("Contato Cadastrado com Sucesso");
		System.out.println(contato.toString());
		System.out.println("----------------");

		meusContatos.add(contato);
		
	}
	
	public static void buscarContato(String nome, ArrayList<Pessoa> meusContatos) {
		
		int encontrado = 0;
		
		for(Pessoa pessoa : meusContatos) {
			if(nome.equals(pessoa.getNome())) {
				System.out.println("\nContato encontrado com sucesso. Segue os dados completos:");
				System.out.println(pessoa.toString());
				encontrado = 1;
				break;
			}
		}
		
		if(encontrado != 1) {
			System.out.println("\nContato não encontrado. Tente novamente ou adicione o contato à lista.");
		}
		System.out.println("----------------");
		
		encontrado = 0;
	}
	
	public static void atualizarContato(String nome, ArrayList<Pessoa> meusContatos) {
		
		int encontrado = 0;
		Scanner scan = new Scanner(System.in);
		
		for(Pessoa pessoa : meusContatos) {
			if(nome.equals(pessoa.getNome())) {
				
				System.out.println("Digite o nome atualizado:");
				pessoa.setNome(scan.nextLine());
				
				System.out.println("Digite o sobrenome atualizado:");
				pessoa.setSobrenome(scan.nextLine());

				System.out.println("Digite o telefone atualizado:");
				pessoa.setTelefone(scan.nextLine());

				System.out.println("Digite o email atualizado:");
				pessoa.setEmail(scan.nextLine());
				
				System.out.println("Digite a profissão atualizada:");
				pessoa.setProfissao(scan.nextLine());

				System.out.println("----------------");
				System.out.println("Contato Atualizado com Sucesso");
				System.out.println(pessoa.toString());

				encontrado = 1;
				break;
			}
		}
		
		if(encontrado != 1) {
			System.out.println("\nContato não encontrado. Tente novamente ou adicione o contato à lista.");
		}
		System.out.println("----------------");
		
		encontrado = 0;
		
	}
	
	public static void removerContato(String nome, ArrayList<Pessoa> meusContatos) {
		
		int encontrado = 0;
		
		for(Pessoa pessoa : meusContatos) {
			if(nome.equals(pessoa.getNome())) {
								
				meusContatos.remove(pessoa);
				
				System.out.println("Contato apagado com sucesso!");
				
				encontrado = 1;
				break;
			}
		}
		
		if(encontrado != 1) {
			System.out.println("Contato não encontrado. Tente novamente.");
		}
		
		System.out.println("----------------");
	}

	public static void listarContatos(ArrayList<Pessoa> meusContatos) {
		
		int i = 1;
		
		for(Pessoa pessoa : meusContatos) {
			if(pessoa.getNome() != null) {
				System.out.println("Contato " + i + ":");
				System.out.println(pessoa.toString());
				i++;
			}
		}
		
		if(i == 1) {
			System.out.println("Não há contatos na sua agenda! Adicione um contato selecionando a tecla 1.");
		}
		System.out.println("----------------");

	}
}