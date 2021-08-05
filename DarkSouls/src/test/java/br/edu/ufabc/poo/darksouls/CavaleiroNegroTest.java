package br.edu.ufabc.poo.darksouls;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufabc.poo.darksouls.inimigos.CavaleiroNegro;
import br.edu.ufabc.poo.darksouls.jogador.Jogador;
import br.edu.ufabc.poo.darksouls.jogador.Mago;

public class CavaleiroNegroTest {
	
	private Jogador jogador;
	private CavaleiroNegro cavaleiroNegro;
	
	@Before
	public void inicializa() {
		jogador = new Mago("Larissa", 200, "Cajado");
		cavaleiroNegro = new CavaleiroNegro("Cavaleiro Negro", 150, "Espada Longa");
	}
	
	@Test
    public void testeCavaleiroNegroAtacando() {
    	assertEquals("Cavaleiro Negro atacando normal", cavaleiroNegro.atacando(jogador));
    	assertEquals("Atacando rapido!", cavaleiroNegro.ataqueRapido(jogador));
    	
    	for(int i=0; i<5; i++) {
    		cavaleiroNegro.ataqueRapido(jogador);
    	}
    	
    	assertEquals("Você está morto.", cavaleiroNegro.atacando(jogador));
    	
    }
    
    @Test
    public void testeCavaleiroNegroTomandoDano() {
    	
    	assertEquals("O inimigo levou 25.0 de dano.", cavaleiroNegro.tomarDano(jogador.getDano()));
    	
    	for(int i=0; i<5; i++) {
    		cavaleiroNegro.tomarDano(jogador.getDano());
    	}
    	
    	assertEquals("O inimigo Cavaleiro Negro morreu.", cavaleiroNegro.tomarDano(jogador.getDano()));
    	
    }
}
