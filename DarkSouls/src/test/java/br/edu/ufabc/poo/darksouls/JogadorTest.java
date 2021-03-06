package br.edu.ufabc.poo.darksouls;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufabc.poo.darksouls.inimigos.CavaleiroNegro;
import br.edu.ufabc.poo.darksouls.inimigos.CavaleiroPrata;
import br.edu.ufabc.poo.darksouls.inimigos.ZumbiLerdo;
import br.edu.ufabc.poo.darksouls.jogador.Arqueiro;
import br.edu.ufabc.poo.darksouls.jogador.Guerreiro;
import br.edu.ufabc.poo.darksouls.jogador.Mago;
import br.edu.ufabc.poo.darksouls.jogador.Sacerdote;

public class JogadorTest {
	
	private Mago jogadorMago;
	private Guerreiro jogadorGuerreiro;
	private Arqueiro jogadorArqueiro;
	private Sacerdote jogadorSacerdote;
	private ZumbiLerdo zumbi;
	private CavaleiroNegro cavaleiroNegro;
	private CavaleiroPrata cavaleiroPrata;
	
	@Before
	public void inicializa() {
		jogadorMago = new Mago ("Larissa", 100, "Cajado");
		jogadorGuerreiro = new Guerreiro ("Leonardo", 300, "Machado");
		jogadorArqueiro = new Arqueiro ("Leticia", 200, "Arco");
		jogadorSacerdote = new Sacerdote ("Rob", 120, "Cajado");
		zumbi = new ZumbiLerdo("Zumbi Lerdo", 50, "Espada Curta");
		cavaleiroNegro = new CavaleiroNegro("Cavaleiro Negro", 150, "Espada Longa");
		cavaleiroPrata = new CavaleiroPrata("Cavaleiro Prata", 175, "Silver Sword");
	}
	
	@Test
	public void testAtacar() {
		assertEquals("Soltando feitiços em Zumbi Lerdo", jogadorMago.atacar(zumbi));
		assertEquals("Atacando com o machado em Cavaleiro Negro", jogadorGuerreiro.atacar(cavaleiroNegro));
		assertEquals("Lançando flechas em Cavaleiro Prata", jogadorArqueiro.atacar(cavaleiroPrata));
		assertEquals("Soltando poderes em Cavaleiro Prata", jogadorSacerdote.atacar(cavaleiroPrata));
		
		jogadorMago.atacar(zumbi);
		
		assertEquals("Inimigo está morto", jogadorMago.atacar(zumbi));
	}
	
	@Test
	public void testTomarDano() {
		assertEquals("O jogador levou 25.0 de dano.", jogadorGuerreiro.tomarDano(cavaleiroNegro.getDano()));
    	
    	for(int i=0; i<11; i++) {
    		jogadorGuerreiro.tomarDano(cavaleiroNegro.getDano());
    	}
    	
    	assertEquals("Você está morto.", jogadorGuerreiro.tomarDano(cavaleiroNegro.getDano()));
	}
	
	@Test
	public void testBatalha(){
		
		while(jogadorMago.getVida() != 0 && zumbi.getVida() != 0) {
			jogadorMago.atacar(zumbi);
			zumbi.atacando(jogadorMago);
		}
		assertEquals("O vencedor da primeira batalha é: ", jogadorMago.getName(), jogadorMago.getVida() != 0 ? jogadorMago.getName() : zumbi.getName());
		
		while(jogadorArqueiro.getVida() != 0 && cavaleiroNegro.getVida() != 0) {
			jogadorArqueiro.atacar(cavaleiroNegro);
			cavaleiroNegro.ataqueRapido(jogadorArqueiro);
		}
		assertEquals("O vencedor da segunda batalha é: ", cavaleiroNegro.getName(), jogadorArqueiro.getVida() != 0 ? jogadorArqueiro.getName() : cavaleiroNegro.getName());
		
		while(jogadorGuerreiro.getVida() != 0 && cavaleiroPrata.getVida() != 0) {
			jogadorGuerreiro.atacar(cavaleiroPrata);
			cavaleiroPrata.ataqueForte(jogadorGuerreiro);
		}
		assertEquals("O vencedor da terceira batalha é: ", cavaleiroPrata.getName(), jogadorGuerreiro.getVida() != 0 ? jogadorGuerreiro.getName() : cavaleiroPrata.getName());
		
		//Simulaçao do jogador sacerdote atacando o mesmo cavaleiro prata
		while(jogadorSacerdote.getVida() != 0 && cavaleiroPrata.getVida() != 0) {
			jogadorSacerdote.atacar(cavaleiroPrata);
			cavaleiroPrata.ataqueForte(jogadorSacerdote);
			jogadorSacerdote.recuperarVida();
		}
		assertEquals("O vencedor da terceira batalha é: ", jogadorSacerdote.getName(), jogadorSacerdote.getVida() != 0 ? jogadorSacerdote.getName() : cavaleiroPrata.getName());

	}
	
	@Test
	public void testRecuperarVida() {
		cavaleiroNegro.atacando(jogadorSacerdote);
		cavaleiroPrata.atacando(jogadorMago);
		
		assertEquals("O sacerdote está com 95 de vida", 95.0, jogadorSacerdote.getVida(), 0);
		assertEquals("O mago está com 50 de vida", 50.0, jogadorMago.getVida(), 0);
		
		jogadorSacerdote.recuperarVida();
		jogadorMago.recuperarVida();
		
		assertEquals("O sacerdote está com 120 de vida", 120.0, jogadorSacerdote.getVida(), 0);
		assertEquals("O mago está com 60 de vida", 60.0, jogadorMago.getVida(), 0);
		
	}

}
