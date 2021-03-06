package br.edu.ufabc.poo.carro;

public abstract class Carro {
	
	protected int velocidadeMax;
	protected int velocidade = 0;
	
	public Carro(int velocidadeMax){
		this.velocidadeMax = velocidadeMax;
	}
	
	public int getVelocidade() {
		return velocidade;
	}
	
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
	public abstract void acelerar();
	
	public abstract void frear();

}