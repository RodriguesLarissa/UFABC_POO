package br.edu.ufabc.poo.carro;

public class CarroTurbo extends Carro {
	
	private int potenciaMotor;
	
	public CarroTurbo (int velocidadeMax, int potenciaMotor){
		super(velocidadeMax);
		this.potenciaMotor = potenciaMotor;
	}
	
	public void acelerar(){
		
		velocidade += potenciaMotor;
		
		if(velocidade > velocidadeMax) {
			velocidade = velocidadeMax;
		}
		
	}
	
	public void frear() {
		velocidade /= 2 ;
	}
	
}
