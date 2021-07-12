package br.edu.ufabc.poo.carro.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufabc.poo.carro.Carro;
import br.edu.ufabc.poo.carro.CarroEletrico;

public class TestCarroEletrico {
	
	private Carro c;

	@Before
	public void inicializaCarro() {
		c = new CarroEletrico(150,20,2);
	}
	
	@Test
	public void criaCarroParado() {
		assertEquals(0, c.getVelocidade());
	}
	
	@Test
	public void acelerar() {
		c.acelerar();
		assertEquals("Acelerou 1 vez", 20, c.getVelocidade());
		c.acelerar();
		c.acelerar();
		assertEquals("Acelerou 3 vez", 80, c.getVelocidade());
	}
	
	@Test
	public void frear() {
		c.acelerar();
		c.frear();
		assertEquals(10, c.getVelocidade());
	}

}
