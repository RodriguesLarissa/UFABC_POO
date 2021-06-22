package br.edu.ufabc.poo.carro;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CorridaTest {

	private Carro carroElet;
	private Carro carroTurb;
	private GrandePremio premio;
	ArrayList<Carro> carros = new ArrayList<Carro>();
	
	@Before
	public void inicializa() {
		carroElet = new CarroEletrico(200, 20, 10);
		carroTurb = new CarroTurbo(100, 15);
		premio = new GrandePremio("Formula 1", 300, carros);
		carros.add(carroElet);
		carros.add(carroTurb);
	}
	
	@Test
	public void criaCarroParado() {
		assertEquals(0, carroElet.getVelocidade());
		assertEquals(0, carroTurb.getVelocidade());
	}
	
	@Test
	public void acelerar() {
		carroElet.acelerar();
		carroTurb.acelerar();
		assertEquals("O carro eletrico acelerou 1 vez", 20, carroElet.getVelocidade());
		assertEquals("O carro turbo acelerou 1 vez", 15, carroTurb.getVelocidade());
		carroElet.acelerar();
		carroTurb.acelerar();
		carroElet.acelerar();
		carroTurb.acelerar();
		assertEquals("O carro eletrico acelerou 3 vez", 200, carroElet.getVelocidade());
		assertEquals("O carro turbo acelerou 3 vez", 45, carroTurb.getVelocidade());
	}
	
	@Test
	public void frear() {
		carroElet.acelerar();
		carroTurb.acelerar();
		carroElet.acelerar();
		carroTurb.acelerar();
		carroElet.frear();
		carroTurb.frear();
		assertEquals("O carro eletrico freou apos acelerar 2 vezes", 195, carroElet.getVelocidade());
		assertEquals("O carro turbo freou apos acelerar 2 vezes", 15, carroTurb.getVelocidade());
	}
	
	@Test
	public void distancia() {
		premio.correr();
		int i = 0;
		
		for(Carro carro : carros) {
			i++;
			if(carro.getDistancia() >= premio.getDistanciaCorrida()) {
				assertEquals("O vencedor é o carro numero: ", 1, i);
			}
		}
	}
	

}
