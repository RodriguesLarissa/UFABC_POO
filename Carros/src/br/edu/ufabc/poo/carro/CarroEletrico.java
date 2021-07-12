package br.edu.ufabc.poo.carro;

public class CarroEletrico extends Carro {
	
	private int velocidadeInicial;
	private int fatorAceleracao;
	
	public CarroEletrico (int velocidadeMax, int velocidadeInicial, int fatorAceleracao){
		super(velocidadeMax);
		this.velocidadeInicial = velocidadeInicial;
		this.fatorAceleracao = fatorAceleracao;
	}
	
	@Override
	public void acelerar(){
		velocidade *= fatorAceleracao;
		
		if(velocidade < velocidadeInicial) {
			velocidade = velocidadeInicial;
		}
		else if(velocidade > this.velocidadeMax) {
			velocidade = this.velocidadeMax;
		}
	}
	
	public void frear() {
		velocidade /= fatorAceleracao ;
	}

}
