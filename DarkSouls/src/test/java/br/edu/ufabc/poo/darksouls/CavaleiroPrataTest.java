package br.edu.ufabc.poo.darksouls;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufabc.poo.darksouls.inimigos.CavaleiroPrata;
import br.edu.ufabc.poo.darksouls.jogador.Jogador;
import br.edu.ufabc.poo.darksouls.jogador.Mago;

public class CavaleiroPrataTest {
	
	private Jogador jogador;
	private CavaleiroPrata cavaleiroPrata;
	
	@Before
	public void inicializa() {
		jogador = new Mago("Larissa", 200, "Cajado");
		cavaleiroPrata = new CavaleiroPrata("Cavaleiro Prata", 175, "Silver Sword");
	}
	
	@Test
    public void testeCavaleiroPrataAtacando() {
    	
    	assertEquals("Cavaleiro de Prata atacando", cavaleiroPrata.atacando(jogador));
    	assertEquals("Ataque forte!", cavaleiroPrata.ataqueForte(jogador));
    	
    	cavaleiroPrata.ataqueForte(jogador);
    	
    	assertEquals("Você está morto.", cavaleiroPrata.atacando(jogador));
    }
    
    @Test
    public void testeCavaleiroPrataTomandoDano() {
    	
      	assertEquals("O inimigo levou 25.0 de dano.", cavaleiroPrata.tomarDano(jogador.getDano()));
    	
    	for(int i=0; i<7; i++) {
    		cavaleiroPrata.tomarDano(jogador.getDano());
    	}
    	
    	assertEquals("O inimigo Cavaleiro Prata morreu.", cavaleiroPrata.tomarDano(jogador.getDano()));
    }
    
	@Test
    public void testeCavaleiroPrataCurando() {
    	
    	for(int i=0; i<6; i++) {
    		cavaleiroPrata.tomarDano(jogador.getDano());
    	}
    	
    	assertEquals("O inimigo deve ter 25 de vida", 25.0, cavaleiroPrata.getVida(), 0);
    	
    	cavaleiroPrata.recuperarVida();
    	
    	assertEquals("O inimigo deve ter 40 de vida", 40.0, cavaleiroPrata.getVida(), 0);
    	
    	
    }
    
}
