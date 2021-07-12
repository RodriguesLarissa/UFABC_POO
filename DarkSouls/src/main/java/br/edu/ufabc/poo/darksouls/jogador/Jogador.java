package br.edu.ufabc.poo.darksouls.jogador;

import br.edu.ufabc.poo.darksouls.inimigos.Inimigo;

public abstract class Jogador {
	
	protected String nome;
	protected double vida;
	protected String tipoArma;
	protected int dano;
	
	public Jogador(String nome, double vida, String tipoArma) {
		this.nome = nome;
		this.vida = vida;
		this.tipoArma = tipoArma;
		if(tipoArma.equals("Cajado")) {
			dano = 25;
		}
		else if(tipoArma.equals("Machado")) {
			dano = 35;
		}
		else if(tipoArma.equals("Arco")) {
			dano = 15;
		}
	}
	
	public abstract String atacar(Inimigo inimigo);
	
	public String tomarDano(double danoInimigo) {
		vida -= danoInimigo;
		if(vida <= 0) {
			vida = 0;
			return ("Você está morto.");
		}
		return ("O jogador levou " + danoInimigo + " de dano.");
		
	}
	
	public int getDano() {
		return dano;
	}
	
	public double getVida() {
		return vida;
	}
	
	public String getName() {
		return nome;
	}
	
	public String mostrarInfo() {
		return "Nome do jogador: " + nome + "\n" +
			   "Vida do jogador: " + vida + "\n" +
			   "Arma do jogador: " + tipoArma + "\n";
	}

}
