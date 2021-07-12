package br.edu.ufabc.poo.carro.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufabc.poo.carro.Carro;
import br.edu.ufabc.poo.carro.CarroEletrico;
import br.edu.ufabc.poo.carro.CarroTurbo;
import br.edu.ufabc.poo.carro.GrandePremio;

public class TestGrandePremio {

	private GrandePremio grandePremio;
	
	@Before
	public void inicializaCorrida() {
		ArrayList<Carro> carros = new ArrayList<Carro>();
		 
		carros.add(new CarroTurbo(180, 20));
		carros.add(new CarroTurbo(220, 30));
		carros.add(new CarroTurbo(250, 40));
		carros.add(new CarroEletrico(180, 20, 2));
		carros.add(new CarroEletrico(220, 30, 3));
		carros.add(new CarroEletrico(250, 40, 3));
		
		grandePremio = new GrandePremio("Grande Prêmio do Brasil", 1000000, carros);
	}
	
	@Test
	public void correr() {
		int[] distancias = grandePremio.correr();
		
		assertEquals(distancias[0], 427697);
		assertEquals(distancias[1], 643933);
		assertEquals(distancias[2], 860181);
		assertEquals(distancias[3], 757050);
		assertEquals(distancias[4], 879984);
		assertEquals(distancias[5], 1000224);
		
	}
}
