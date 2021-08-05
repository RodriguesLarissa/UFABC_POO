package br.edu.ufabc.poo.lab9;

import br.edu.ufabc.poo.exceptions.SaldoInsuficienteException;

public class ContaEspecial extends Conta {

	public ContaEspecial(float saldo, float limite){
		super(saldo, limite);
	}
	
	@Override
	public void sacar(float quantia) throws SaldoInsuficienteException {
		if(quantia < (saldo+limite))
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
