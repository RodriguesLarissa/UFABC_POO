package br.edu.ufabc.poo.carro;

import java.util.ArrayList;

public class GrandePremio {

	ArrayList<Carro> carros;
	private String nome;
	private int distanciaCorrida;

	public GrandePremio(String nome, int distanciaCorrida, ArrayList<Carro> carros) {
		this.nome = nome;
		this.distanciaCorrida = distanciaCorrida;
		this.carros = carros;
	}
	
	public int[] correr() {
		int acao = 0;
		boolean vencedor = false;
		int[] distanciaPercorrida = new int[carros.size()];
		
		while(!vencedor) {
			for(Carro carro : carros) {
				if(acao%4 == 0) {
					carro.frear();	
				}
				else {
					carro.acelerar();
				}
				distanciaPercorrida[carros.indexOf(carro)] += carro.getVelocidade();
			}
			acao++;
			
			for(int i=0; i< this.carros.size(); i++) {
				if(distanciaPercorrida[i] >= distanciaCorrida) {
					vencedor = true;
				}
			}
		}
		return distanciaPercorrida;
	}
	
	public int getDistanciaCorrida() {
		return distanciaCorrida;
	}
	

	public String getNome() {
		return nome;
	}
		

}
