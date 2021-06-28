package modelo;

public class Pessoa {

	private static int ultimoId = 0;

	private int id;
	private String nome;
	private String sobrenome;
	private String telefone;
	private String email;
	private String profissao;

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

	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}
	
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String toString() {
		return  "Id: " + this.id + "\n" +
				"Nome: " + this.nome + "\n" +
				"Sobrenome: " + this.sobrenome + "\n" +
				"Telefone: " + this.telefone + "\n" +
				"Email: " + this.email + "\n" +
				"Profissão: " + this.profissao + "\n";
				
	}

}