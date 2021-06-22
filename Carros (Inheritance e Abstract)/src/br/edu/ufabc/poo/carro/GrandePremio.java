package br.edu.ufabc.poo.carro;

import java.util.ArrayList;

public class GrandePremio {

	ArrayList<Carro> carros;

	private String nome;
	private int distanciaCorrida;
	int dist = 0, distMaior = 0;

	public GrandePremio(String nome, int distanciaCorrida, ArrayList<Carro> carros) {
		this.nome = nome;
		this.distanciaCorrida = distanciaCorrida;
		this.carros = carros;
	}

	public void correr() {

		while(distMaior < distanciaCorrida) {
			
			for(Carro carro : carros) {
				carro.acelerar();
				carro.acelerar();
				carro.frear();
				dist = carro.getDistancia() + carro.getVelocidade();
				carro.setDistancia(dist); 
				
				if(carro.getDistancia() > distMaior) {
					distMaior = carro.getDistancia();
				}
			}

		}
	}
	
	public int getDistanciaTotal() {
		return distMaior;
	}
	
	public int getDistanciaCorrida() {
		return distanciaCorrida;
	}
		

}
