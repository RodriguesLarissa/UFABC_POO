package controle;

import java.util.ArrayList;
import java.util.Date;

import modelo.Pessoa;

public class ControleAgenda {
	
	private ArrayList<Pessoa> meusContatos;
	
	public ControleAgenda() {
		meusContatos = new ArrayList<Pessoa>();
	}
	
	public Pessoa adicionarContato(String nome, String sobrenome, String telefone, String email, String profissao, Date aniversario) {
		Pessoa contato = new Pessoa(nome);
		contato = this.dadosContato(contato, sobrenome, telefone, email, profissao, aniversario);
		this.meusContatos.add(contato);
		return contato;
	}
	
	private Pessoa dadosContato(Pessoa contato,String sobrenome, String telefone, String email, String profissao, Date aniversario) {
		contato.setSobrenome(sobrenome);
		contato.setTelefone(telefone);
		contato.setEmail(email);
		contato.setProfissao(profissao);
		contato.setAniversario(aniversario);
		
		return contato;
	}
	
	public Pessoa buscarContato(String nome) {
		Pessoa contato = buscarNome(nome);
		return contato;
	}
	
	private Pessoa buscarNome(String nome) {
		for (Pessoa pessoa: meusContatos) {
			String nomePesquisado = pessoa.getNome();
		
			if(nomePesquisado.equalsIgnoreCase(nome)) {
				return pessoa;
			}
		}
		return null;
	}
	
	public Pessoa atualizarContato(Pessoa contato, String nome, String sobrenome, String telefone, String email, String profissao, Date aniversario) {
		contato.setNome(nome);
		contato = this.dadosContato(contato, sobrenome, telefone, email, profissao, aniversario);
		return contato;
	}
	
	public boolean removerContato(String nome) {
		Pessoa contato = buscarNome(nome);
		
		if(contato == null) {
			return false;
		}
		else {
			meusContatos.remove(contato);
			return true;
		}
	}
	
	public ArrayList<Pessoa> listarContatos() {
		return this.meusContatos;
	}
}
