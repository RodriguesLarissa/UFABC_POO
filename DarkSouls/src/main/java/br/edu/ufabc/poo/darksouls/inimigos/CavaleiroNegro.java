package br.edu.ufabc.poo.darksouls.inimigos;

import br.edu.ufabc.poo.darksouls.jogador.Jogador;

public class CavaleiroNegro extends Inimigo {

	public CavaleiroNegro(String nome, double vida, String tipoArma) {
		super(nome, vida, tipoArma);
	}
	
	@Override 
	public String atacando(Jogador jogador) {
		if(vida != 0 && jogador.getVida() != 0) {
			jogador.tomarDano(this.dano);
			return ("Cavaleiro Negro atacando normal");
		}
		if(jogador.getVida() == 0) {
			return "Você está morto.";
		}
		else {
			return "Inimigo morto";
		}
		
	}
	
	public String ataqueRapido(Jogador jogador) {
		if(vida != 0 && jogador.getVida() != 0) {
			jogador.tomarDano(this.dano/1.5);
			jogador.tomarDano(this.dano/1.5);
			return ("Atacando rapido!");
		}
		if(jogador.getVida() == 0) {
			return "Você está morto.";
		}
		else {
			return "Inimigo morto";
		}
	}
}
