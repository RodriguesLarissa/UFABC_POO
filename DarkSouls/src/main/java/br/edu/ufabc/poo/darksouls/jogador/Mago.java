package br.edu.ufabc.poo.darksouls.jogador;

import br.edu.ufabc.poo.darksouls.inimigos.Inimigo;

public class Mago extends Jogador {
	
	public Mago(String nome, double vida, String tipoArma) {
		super(nome, vida, tipoArma);
	}
	
	@Override
	public String atacar(Inimigo inimigo) {
		if(vida > 0 && inimigo.getVida() != 0) {
			inimigo.tomarDano(this.dano);
			return ("Soltando feitiços em " + inimigo.getName());
		}
		else if(inimigo.getVida() == 0) {
			return "Inimigo está morto";
		}
		else {
			return "Você está morto.";
		}
	}
	
}
