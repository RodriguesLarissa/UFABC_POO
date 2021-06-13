package br.edu.ufabc.poo.carro;

public class Principal {
	
	public static void main(String[] args) {
		
		Carro ferrari;
		Carro bmw;
		
		ferrari = new Carro(15, 200);
		bmw = new Carro(12, 150);
		
		for(int i=0; i<15; i++) {
			ferrari.acelerar();
			bmw.acelerar();
		}
		
		for(int i=0; i<2; i++) {
			ferrari.frear();
			bmw.frear();
		}
		
		for(int i=0; i<3; i++) {
			ferrari.acelerar();
			bmw.acelerar();
		}
		
		System.out.println("A velocidade atual da Ferrari é: " + ferrari.getVelocidade() + "km/h");
		System.out.println("A velocidade atual do BMW é: " + bmw.getVelocidade() + "km/h");
	}
}
