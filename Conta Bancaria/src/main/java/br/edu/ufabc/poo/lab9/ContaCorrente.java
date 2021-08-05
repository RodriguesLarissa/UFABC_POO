package br.edu.ufabc.poo.lab9;

import br.edu.ufabc.poo.exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(float saldo, float limite){
		super(saldo, limite);
	}
	
	@Override
	public void sacar(float quantia) throws SaldoInsuficienteException{
		if(quantia < this.saldo)
			try {
				this.saldo -= quantia;
			} catch (Exception e) {
				e.printStackTrace();
			}
		else {
			throw new SaldoInsuficienteException("Saldo Insuficiente");
		}
	}	

}
