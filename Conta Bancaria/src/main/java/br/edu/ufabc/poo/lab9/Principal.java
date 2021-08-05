package br.edu.ufabc.poo.lab9;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ufabc.poo.exceptions.SaldoInsuficienteException;

public class Principal {
	
	private static ArrayList<Conta> contas;
	private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int conta = -1;
		contas = new ArrayList<Conta>();
		
		while(conta != 0) {
			
			conta = menu();
			
			switch (conta) {
				case 1: {
					adicionarConta(contas);
					break;
				}
				case 2: {
					visualizarConta(contas);
					break;
				}
				case 3: {
					excluirConta(contas);
					break;
				}
				case 0: {
					System.out.println("Obrigado por usar nosso banco.");
					System.exit(conta);
				}
				default:{
					System.out.println("Opção " + conta + " inválida.");
					break;
				}
			}
			
		}	
		entrada.close();
	}
	
	private static int menu() {
		System.out.println("Digite uma opção:");
		System.out.println("1- Criar conta");
		System.out.println("2- Visualizar conta");
		System.out.println("3- Excluir conta");
		System.out.println("0- Sair");
		System.out.println("----------------");

		return Integer.parseInt(entrada.nextLine());
	}
	
	private static int menuConta() {
		System.out.println("Digite uma opção:");
		System.out.println("1- Adicionar cliente");
		System.out.println("2- Sacar dinheiro");
		System.out.println("3- Depositar dinheiro");
		System.out.println("4- Informações da conta");
		System.out.println("0- Sair");
		System.out.println("----------------");

		return Integer.parseInt(entrada.nextLine());
	}
	
	private static void adicionarConta(ArrayList<Conta> contas) {
		
		float saldo, limite = 0;
		Conta conta;
		
		System.out.println("Escolha qual tipo de conta deseja criar:");
		System.out.println("1- Conta Corrente");
		System.out.println("2- Conta Especial");
		
		int opcao = Integer.parseInt(entrada.nextLine());
		
		System.out.println("Qual o saldo desta conta?");
		saldo = Float.parseFloat(entrada.nextLine());
		
		if(opcao == 1) {
			conta = new ContaCorrente(saldo, 0);
			adicionarCliente(conta);
			contas.add(conta);
		}
		else if(opcao == 2) {
			System.out.println("Qual o limite desta conta?");
			limite = Float.parseFloat(entrada.nextLine());
			conta = new ContaEspecial(saldo, limite);
			adicionarCliente(conta);
			contas.add(conta);
		}
		else {
			System.out.println("Opção " + opcao + " inválida.");
		}
	}
	
	private static void visualizarConta(ArrayList<Conta> contas) {
		int opcao = -1;
		String nome;
		Conta contaAtual = null;
		
		System.out.println("Qual o nome do cliente no qual deseja visualizar a conta?");
		nome = entrada.nextLine();
		
		for(Conta conta : contas) {
			for(Cliente cliente : conta.getClientes()) {
				if(cliente.getNome().equals(nome)) {
					contaAtual = conta;
					break;
				}
			}
		}
		
		if(contaAtual == null) {
			System.out.println("Cliente não encontrado.\n");
		}
		
		while(opcao != 0 && contaAtual != null) {
			opcao = menuConta();
			
			switch (opcao) {
				case 1: {
					adicionarCliente(contaAtual);
					break;
				}
				case 2: {
					sacarDinheiro(contaAtual);
					break;
				}
				case 3: {
					depositarDinheiro(contaAtual);
					break;
				}
				case 4: {
					System.out.println(contaAtual.toString() + "\n");
					break;
				}
				case 0: {
					break;
				}
				default:{
					System.out.println("Opção " + opcao + " inválida.");
					break;
				}
			}
		}
	}
	
	private static void excluirConta(ArrayList<Conta> contas) {
		
		String nome;
		Conta contaAtual = null;
		
		System.out.println("Qual o nome do cliente no qual deseja excluir a conta?");
		nome = entrada.nextLine();
		
		for(Conta conta : contas) {
			for(Cliente cliente : conta.getClientes()) {
				if(cliente.getNome().equals(nome)) {
					contaAtual = conta;
					break;
				}
			}
		}
		
		if(contaAtual == null) {
			System.out.println("Cliente não encontrado.\n");
		}
		
		if(contaAtual != null) {
			contas.remove(contaAtual);
			System.out.println("Cliente excluido com sucesso.\n");
		}
	}
	
	private static void adicionarCliente(Conta c1) {
		
		Cliente cliente;
		
		System.out.println("Digite o nome do cliente:");
		String nome = entrada.nextLine();
		
		System.out.println("Digite o CPF do cliente:");
		long cpf = Long.parseLong(entrada.nextLine());
		
		cliente = new Cliente(nome, cpf);
		c1.addCliente(cliente);
		
		System.out.println("Cliente Cadastrado com Sucesso\n");
		
	}
	
	private static void sacarDinheiro(Conta c1) {
		
		int valor;
		System.out.println("Quanto você deseja sacar?");
		valor = Integer.parseInt(entrada.nextLine());
		
		try {
			c1.sacar(valor);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage() + "\n");
		}

	}
	
	private static void depositarDinheiro(Conta c1) {
		
		int valor;
		
		System.out.println("Quanto você deseja depositar?");
		valor = Integer.parseInt(entrada.nextLine());
		
		c1.depositar(valor);
		
	}

}
