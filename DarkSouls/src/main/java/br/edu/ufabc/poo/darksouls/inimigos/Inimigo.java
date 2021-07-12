package br.edu.ufabc.poo.darksouls.inimigos;

import br.edu.ufabc.poo.darksouls.jogador.Jogador;

public abstract class Inimigo {

	protected String nome;
	protected double vida;
	protected String tipoArma;
	protected int dano;

	public Inimigo(String nome, double vida, String tipoArma) {
		this.nome = nome;
		this.vida = vida;
		this.tipoArma = tipoArma;
		if(tipoArma.equals("Espada Curta")) {
			dano = 10;
		}
		else if(tipoArma.equals("Espada Longa")) {
			dano = 25;
		}
		else if(tipoArma.equals("Silver Sword")) {
			dano = 50;
		}
	}

	public abstract String atacando(Jogador jogador);
	
	public String tomarDano(double danoJogador) {
		vida -= danoJogador;
		if(vida <= 0) {
			vida = 0;
			return ("O inimigo " + this.nome + " morreu.");
		}
		return ("O inimigo levou " + danoJogador + " de dano.");
		
	}
	
	public String getName() {
		return nome;
	}
	
	public int getDano() {
		return dano;
	}
	
	public double getVida() {
		return vida;
	}
	
	public String mostrarInfo() {
		return "Nome do inimigo: " + nome + "\n" +
			   "Vida do inimigo: " + vida + "\n" +
			   "Arma do inimigo: " + tipoArma + "\n";
	}

}