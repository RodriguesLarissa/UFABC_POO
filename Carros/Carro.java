package br.edu.ufabc.poo.carro;

public class Carro {
	
	private int potencia;
	private int velocidadeMax;
	private int velocidade = 0;
	
	public Carro(int potencia, int velocidadeMax){
		this.potencia = potencia;
		this.velocidadeMax = velocidadeMax;
	}
	
	public void acelerar(){
		if(velocidade+potencia <= velocidadeMax) {
			velocidade += potencia;
		}
		else {
			velocidade = velocidadeMax;
		}
	}
	
	public void frear() {
		if((velocidade/2)  > 0) {
			velocidade /= 2 ;
		}
		else {
			velocidade = 0;
		}
	}
	
	public int getVelocidade() {
		return velocidade;
	}
}