package br.edu.ufabc.poo.carro;

import java.util.ArrayList;

public class Corrida {

	public static void main(String[] args) {
		
		ArrayList<Carro> carros = new ArrayList<Carro>();
		
		CarroTurbo carro1 = new CarroTurbo(180, 20);
		CarroTurbo carro2 = new CarroTurbo(220, 30);
		CarroTurbo carro3 = new CarroTurbo(250, 40);
		CarroEletrico carro4 = new CarroEletrico(180, 20, 2);
		CarroEletrico carro5 = new CarroEletrico(220, 30, 3);
		CarroEletrico carro6 = new CarroEletrico(250, 40, 3);
		
		carros.add(carro1);
		carros.add(carro2);
		carros.add(carro3);
		carros.add(carro4);
		carros.add(carro5);
		carros.add(carro6);
		
		GrandePremio premio = new GrandePremio("Formula 1", 1000000, carros);
		
		int[] distancias = premio.correr();
							
		System.out.println(premio.getNome() + "(Resultado):\n");
		
		int i;
		for(Carro carro : carros) {
			i = carros.indexOf(carro);
			System.out.println("Carro " + i + ": " + distancias[i] + " metros\n");
		}
		
		
	}
	
}
