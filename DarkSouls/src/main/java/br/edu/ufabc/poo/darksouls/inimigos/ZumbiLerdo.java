package br.edu.ufabc.poo.darksouls.inimigos;

import br.edu.ufabc.poo.darksouls.jogador.Jogador;

public class ZumbiLerdo extends Inimigo {

	public ZumbiLerdo(String nome, double vida, String tipoArma) {
		super(nome, vida, tipoArma);
	}
	
	@Override 
	public String atacando(Jogador jogador) {
		if(vida != 0 && jogador.getVida() != 0) {
			jogador.tomarDano(this.dano);
			return ("Zumbi Lerdo atacando");
		}
		if(jogador.getVida() == 0) {
			return "Você está morto.";
		}
		else {
			return "Inimigo morto";
		}
		
	}

}