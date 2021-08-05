package br.edu.ufabc.poo.lab9;

import br.edu.ufabc.poo.exceptions.SaldoInsuficienteException;

public class Conta {

	protected float saldo;
	protected float limite;
	private Cliente[] clientes;

	public Conta(float saldo, float limite) {
		this.saldo = saldo;
		this.limite = limite;
		this.clientes = new Cliente[4];
	}

	public void addCliente(Cliente cliente) {
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i] == null) {
				clientes[i] = cliente;
				break;
			}
		}
	}
	
	public Cliente[] getClientes() {
		return clientes;
	}
	
	public void sacar(float quantia) throws SaldoInsuficienteException {
		this.saldo -= quantia;
	}
	
	public void depositar (float quantia) {
		this.saldo += quantia;
	}

	public String toString() {
		
		
		String informacoesConta = "Saldo da Conta: " + saldo + "\n" +
									"Limite da Conta: " + limite + "\n\n";
		

		for(Cliente cliente: clientes) {
			try {
				informacoesConta += "Nome do cliente: " + cliente.getNome() + "\n" +
									"CPF do cliente: " + cliente.getCpf() + "\n";
			} catch(NullPointerException e) {
				informacoesConta += "Cliente Inexistente\n";
			}
		}

		return informacoesConta;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public float getLimite() {
		return limite;
	}
	
}