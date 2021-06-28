package br.edu.ufabc.poo.carro;

public class CarroEletrico extends Carro {
	
	private int velocidadeInicial;
	private int fatorAceleracao;
	
	public CarroEletrico (int velocidadeMax, int velocidadeInicial, int fatorAceleracao){
		super(velocidadeMax);
		this.velocidadeInicial = velocidadeInicial;
		this.fatorAceleracao = fatorAceleracao;
	}
	
	public void acelerar(){
		if(velocidade == 0) {
			velocidade = velocidadeInicial;
		}
		else {
			velocidade *= fatorAceleracao;
		}
				
		if(velocidade > velocidadeMax) {
			velocidade = velocidadeMax;
		}
	}
	
	public void frear() {
		velocidade -= fatorAceleracao/2 ;
	}

}
