package br.edu.ufabc.poo.darksouls;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufabc.poo.darksouls.inimigos.CavaleiroNegro;
import br.edu.ufabc.poo.darksouls.inimigos.CavaleiroPrata;
import br.edu.ufabc.poo.darksouls.inimigos.ZumbiLerdo;
import br.edu.ufabc.poo.darksouls.jogador.Arqueiro;
import br.edu.ufabc.poo.darksouls.jogador.Guerreiro;
import br.edu.ufabc.poo.darksouls.jogador.Jogador;
import br.edu.ufabc.poo.darksouls.jogador.Mago;

public class InimigoTest{
	
	private Jogador jogador;
	
	@Before
	public void inicializa() {
		jogador = new Arqueiro ("Larissa", 200, "Arco");
	}
	
    @Test
    public void testeZumbiLerdoAtacando() {
    	ZumbiLerdo zumbi =
    			new ZumbiLerdo("Zumbi Lerdo", 50, "Espada Curta");

    	assertEquals("Zumbi Lerdo atacando", zumbi.atacando(jogador));
    	
    	for(int i=0; i<19; i++) {
    		zumbi.atacando(jogador);
    	}
    	
    	assertEquals("Você está morto.", zumbi.atacando(jogador));
	}
    
    @Test
    public void testeZumbiLerdoTomandoDano() {
    	ZumbiLerdo zumbi =
    			new ZumbiLerdo("Zumbi Lerdo", 50, "Espada Curta");

    	assertEquals("O inimigo levou 15.0 de dano.", zumbi.tomarDano(jogador.getDano()));
    	
    	for(int i=0; i<3; i++) {
    		zumbi.tomarDano(jogador.getDano());
    	}
    	
    	assertEquals("O inimigo Zumbi Lerdo morreu.", zumbi.tomarDano(jogador.getDano()));
	}

    @Test
    public void testeCavaleiroNegroAtacando() {

    	CavaleiroNegro cavaleiroNegro =
    			new CavaleiroNegro("Cavaleiro Negro", 150, "Espada Longa");

    	assertEquals("Cavaleiro Negro atacando normal", cavaleiroNegro.atacando(jogador));
    	assertEquals("Atacando rapido!", cavaleiroNegro.ataqueRapido(jogador));
    	
    	for(int i=0; i<5; i++) {
    		cavaleiroNegro.ataqueRapido(jogador);
    	}
    	
    	assertEquals("Você está morto.", cavaleiroNegro.atacando(jogador));
    	
    }
    
    @Test
    public void testeCavaleiroNegroTomandoDano() {
    	
    	jogador = new Mago("Larissa", 200, "Cajado");
    	
    	CavaleiroNegro cavaleiroNegro =
    			new CavaleiroNegro("Cavaleiro Negro", 150, "Espada Longa");

    	assertEquals("O inimigo levou 25.0 de dano.", cavaleiroNegro.tomarDano(jogador.getDano()));
    	
    	for(int i=0; i<5; i++) {
    		cavaleiroNegro.tomarDano(jogador.getDano());
    	}
    	
    	assertEquals("O inimigo Cavaleiro Negro morreu.", cavaleiroNegro.tomarDano(jogador.getDano()));
    	
    }

    @Test
    public void testeCavaleiroPrataAtacando() {
    	
    	CavaleiroPrata cavaleiroPrata =
    			new CavaleiroPrata("Cavaleiro Prata", 175, "Silver Sword");

    	assertEquals("Cavaleiro de Prata atacando", cavaleiroPrata.atacando(jogador));
    	assertEquals("Ataque forte!", cavaleiroPrata.ataqueForte(jogador));
    	
    	cavaleiroPrata.ataqueForte(jogador);
    	
    	assertEquals("Você está morto.", cavaleiroPrata.atacando(jogador));
    }
    
    @Test
    public void testeCavaleiroPrataTomandoDano() {
    	
    	jogador = new Guerreiro ("Larissa", 200, "Machado");
    	
    	CavaleiroPrata cavaleiroPrata =
    			new CavaleiroPrata("Cavaleiro Prata", 175, "Silver Sword");

    	assertEquals("O inimigo levou 35.0 de dano.", cavaleiroPrata.tomarDano(jogador.getDano()));
    	
    	for(int i=0; i<4; i++) {
    		cavaleiroPrata.tomarDano(jogador.getDano());
    	}
    	
    	assertEquals("O inimigo Cavaleiro Prata morreu.", cavaleiroPrata.tomarDano(jogador.getDano()));
    }
}