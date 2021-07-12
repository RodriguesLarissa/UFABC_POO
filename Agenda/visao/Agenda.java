package visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controle.ControleAgenda;
import modelo.Pessoa;

public class Agenda {
	private static ControleAgenda meusContatos;
	private static Scanner entrada;
	
	public static void main(String[] args) {
		
		meusContatos = new ControleAgenda();
		entrada = new Scanner(System.in);
		
		int opcao = -1;
		
		while (opcao !=0) {
			
			opcao = menu();

			switch (opcao) {
				case 1: {
					adicionarContato();
					break;
				}
				case 2: {
					buscarContato();
					break;
				}
				case 3: {
					atualizarContato();
					break;
				}
				case 4: {
					removerContato();	
					break;
				}
				case 5: {
					listarContatos();
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
	
	private static int menu() {
		System.out.println("Digite uma opção:");
		System.out.println("1- Adicionar contato");
		System.out.println("2- Buscar contato");
		System.out.println("3- Atualizar contato");
		System.out.println("4- Remover contato");
		System.out.println("5- Listar todos os contatos");
		System.out.println("0- Sair");
		System.out.println("----------------");

		return Integer.parseInt(entrada.nextLine());
	}
	
	private static void adicionarContato() {
		
		System.out.println("Digite o nome:");
		String nome = entrada.nextLine();
		
		dadosContato(nome, "add");
		
		System.out.println("Contato Cadastrado com Sucesso");
		
	}
	
	private static Pessoa dadosContato(String nome, String tipo) {
	
		System.out.println("Digite o sobrenome:");
		String sobrenome = entrada.nextLine();

		System.out.println("Digite o telefone:");
		String telefone = entrada.nextLine();

		System.out.println("Digite o email:");
		String email = entrada.nextLine();
		
		System.out.println("Digite a profissão:");
		String profissao = entrada.nextLine();
		
		System.out.println("Digite o aniversário (dd/MM/yyyy):");
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Date aniversario = null;
		try {
			aniversario = data.parse(entrada.nextLine());
		}
		catch(ParseException e) {
			System.out.println("Data inválida. Data não registrada");
			e.printStackTrace();
		}
		
		Pessoa contato;
		if(tipo.equals("add")) {
			contato = meusContatos.adicionarContato(nome, sobrenome, telefone, email, profissao, aniversario);
		}
		else {
			contato = meusContatos.buscarContato(nome);
			meusContatos.atualizarContato(contato, nome, sobrenome, telefone, email, profissao, aniversario);
		}
		
		System.out.println("----------------");
		System.out.println(contato.toString());
		System.out.println("----------------");
		return contato;
	}
	
	private static void buscarContato() {

		System.out.println("Digite um nome:");
		Pessoa contato = meusContatos.buscarContato(entrada.nextLine());
		
		if(contato == null) {
			System.out.println("Contato não encontrado!");
		}
		else {
			System.out.println("Contato Encontrado com Sucesso!");
			System.out.println(contato);
		}
		
	}

	private static void atualizarContato() {
		
		System.out.println("Digite um nome:");
		Pessoa contato = meusContatos.buscarContato(entrada.nextLine());
		
		if(contato == null) {
			System.out.println("Contato não encontrado!");
		}
		else {
			System.out.println("----------------");
			System.out.println("Contato Encontrado com Sucesso!");
			System.out.println("Preencha os dados atualizados.");
			System.out.println("----------------");
			System.out.println("Digite o nome:");
			String nome = entrada.nextLine();
			contato.setNome(nome);
		
			dadosContato(nome, "att");
			System.out.println("Contato Atualizado com Sucesso");
		}
	}
	
	private static void removerContato() {
		
		System.out.println("Digite um nome:");
		boolean resultado = meusContatos.removerContato(entrada.nextLine());
		
		if(resultado == false) {
			System.out.println("Contato não encontrado!");
		}
		else {
			System.out.println("Contato removido com sucesso!");
		}
		
	}

	private static void listarContatos() {
		
		int i = 1;
		
		for(Pessoa pessoa : meusContatos.listarContatos()) {
			System.out.println("Contato " + i + ":");
			System.out.println(pessoa);
			i++;
		}
		
		if(i == 1) {
			System.out.println("Não há contatos na sua agenda! Adicione um contato selecionando a tecla 1.");
		}
		System.out.println("----------------");

	}
}