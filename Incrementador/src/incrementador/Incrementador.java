// Código criado pelo professor Paulo Meirelles da instituição UFABC, durante o curso de POO.
// O código foi refeito para treinamento de Orientação à Objeto.

package incrementador;

public class Incrementador {
	private int instancia = 0;
	private static int estatica = 0;
	
	public void incrementar() {
		instancia++;
		estatica++;
	}
	
	public int getValorInstancia() {
		return instancia;
	}
	
	public int getValorEstatica() {
		return estatica;
	}
}
