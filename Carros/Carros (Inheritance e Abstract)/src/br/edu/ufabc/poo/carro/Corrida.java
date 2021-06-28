package br.edu.ufabc.poo.carro;

import java.util.ArrayList;

public class Corrida {

	public static void main(String[] args) {
		
		GrandePremio premio;
		
		ArrayList<Carro> carros = new ArrayList<Carro>();
		
		CarroTurbo carro1 = new CarroTurbo(300, 5);
		CarroTurbo carro2 = new CarroTurbo(200, 10);
		CarroTurbo carro3 = new CarroTurbo(100, 15);
		CarroEletrico carro4 = new CarroEletrico(300, 30, 5);
		CarroEletrico carro5 = new CarroEletrico(200, 20, 10);
		CarroEletrico carro6 = new CarroEletrico(100, 10, 15);
		
		carros.add(carro1);
		carros.add(carro2);
		carros.add(carro3);
		carros.add(carro4);
		carros.add(carro5);
		carros.add(carro6);
		
		premio = new GrandePremio("Formula 1", 100000, carros);
		
		premio.correr();
					
		int i = 0;
				
		for(Carro carro : carros) {
			i++;
			if(carro.getDistancia() >= premio.getDistanciaCorrida()) {
				System.out.println("O vencedor é: Carro " + i);
			}
		}
		
		i = 0;
			
		for(Carro carro : carros) {
			
			i++;
			System.out.println("\n-------------------");
			System.out.println("Carro: " + i);
			System.out.println("Distância percorrida: " + carro.getDistancia());
			
		}
		
		
	}
	
}
