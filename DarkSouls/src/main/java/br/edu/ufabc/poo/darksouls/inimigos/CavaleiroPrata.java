package br.edu.ufabc.poo.darksouls.inimigos;

import br.edu.ufabc.poo.darksouls.jogador.Jogador;

public class CavaleiroPrata extends Inimigo {

	public CavaleiroPrata(String nome, double vida, String tipoArma) {
		super(nome, vida, tipoArma);
	}
	
	@Override 
	public String atacando(Jogador jogador) {
		if(vida != 0 && jogador.getVida() != 0) {
			jogador.tomarDano(this.dano);
			return ("Cavaleiro de Prata atacando");
		}
		if(jogador.getVida() == 0) {
			return "Você está morto.";
		}
		else {
			return "Inimigo morto";
		}
	}
	
	public String ataqueForte(Jogador jogador) {
		if(vida != 0 && jogador.getVida() != 0) {
			jogador.tomarDano(this.dano*1.5);
			return ("Ataque forte!");
		}
		if(jogador.getVida() == 0) {
			return "Você está morto.";
		}
		else {
			return "Inimigo morto";
		}
		
	}

}
