package br.edu.ufabc.poo.darksouls;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufabc.poo.darksouls.inimigos.ZumbiLerdo;
import br.edu.ufabc.poo.darksouls.jogador.Arqueiro;
import br.edu.ufabc.poo.darksouls.jogador.Jogador;

public class ZumbiTest {

	private Jogador jogador;
	private ZumbiLerdo zumbi;
	
	@Before
	public void inicializa() {
		jogador = new Arqueiro ("Larissa", 200, "Arco");
    	zumbi = new ZumbiLerdo("Zumbi Lerdo", 50, "Espada Curta");
	}
	
	@Test
    public void testeZumbiLerdoAtacando() {
    	assertEquals("Zumbi Lerdo atacando", zumbi.atacando(jogador));
    	
    	for(int i=0; i<19; i++) {
    		zumbi.atacando(jogador);
    	}
    	
    	assertEquals("Você está morto.", zumbi.atacando(jogador));
	}
    
    @Test
    public void testeZumbiLerdoTomandoDano() {
    	    	assertEquals("O inimigo levou 15.0 de dano.", zumbi.tomarDano(jogador.getDano()));
    	
    	for(int i=0; i<3; i++) {
    		zumbi.tomarDano(jogador.getDano());
    	}
    	
    	assertEquals("O inimigo Zumbi Lerdo morreu.", zumbi.tomarDano(jogador.getDano()));
	}
	
}
