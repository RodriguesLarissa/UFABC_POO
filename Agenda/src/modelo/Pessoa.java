// Código criado pelo professor Paulo Meirelles da instituição UFABC, durante o curso de POO.
// O código foi refeito para treinamento de Orientação à Objeto.

package modelo;

public class Pessoa {
	
	private static int ultimoId = 0;
	
	private int id;	
	private String nome;
	private String telefone;
	private String email;
	
	public Pessoa(String nome) {
		this.nome = nome;
		this.id = ++ultimoId;
	}
	
	public int getUltimoId() {
		return ultimoId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "\nId: " + this.id + "\n" +
			   "Nome: " + this.nome + "\n" +
			   "Telefone: " + this.telefone + "\n" +
			   "Email: " + this.email + "\n";
	}
}