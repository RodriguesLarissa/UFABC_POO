import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import controle.ControleAgenda;
import modelo.Pessoa;

public class TestControleAgenda {
	private static ControleAgenda meusContatos = new ControleAgenda();
	
	@Before
	public void adicionarContato() throws ParseException {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		meusContatos.adicionarContato("Larissa", "Rodrigues", "1234-5678", "larissa@hotmail.com", "Desenvolvedora", data.parse("13/09/1999"));
		meusContatos.adicionarContato("Leonardo", "Bertassoli", "1478-5236", "leonardo@hotmail.com", "Desenvolvedor", data.parse("05/11/1999"));
		meusContatos.adicionarContato("Alessandra", "Oliveira", "7896-5412", "ale@hotmail.com", "Manicure", data.parse("09/09/1978"));
		meusContatos.adicionarContato("André", "Rodrigues", "9382-7146", "andre@hotmail.com", "Facilities", data.parse("12/08/1978"));
	}
	
	
	@Test
	public void testListagemContatos() {
		assertEquals("[Id: 1\n"
				+ "Nome: Larissa\n"
				+ "Sobrenome: Rodrigues\n"
				+ "Telefone: 1234-5678\n"
				+ "Email: larissa@hotmail.com\n"
				+ "Profissão: Desenvolvedora\n"
				+ "Aniversário: 13/09/1999\n"
				+ ",Id: 2\n"
				+ "Nome: Leonardo\n"
				+ "Sobrenome: Bertassoli\n"
				+ "Telefone: 1478-5236\n"
				+ "Email: leonardo@hotmail.com\n"
				+ "Profissão: Desenvolvedor\n"
				+ "Aniversário: 05/11/1999\n"
				+ ",Id: 3\n"
				+ "Nome: Alessandra\n"
				+ "Sobrenome: Oliveira\n"
				+ "Telefone: 7896-5412\n"
				+ "Email: ale@hotmail.com\n"
				+ "Profissão: Manicure\n"
				+ "Aniversário: 09/09/1978\n"
				+ ",Id: 4\n"
				+ "Nome: André\n"
				+ "Sobrenome: Rodrigues\n"
				+ "Telefone: 9382-7146\n"
				+ "Email: andre@hotmail.com\n"
				+ "Profissão: Facilities\n"
				+ "Aniversário: 12/08/1978\n"
				+ "]", meusContatos.listarContatos());
	}
	
	
	@Test
	public void testAtualizarContato() throws ParseException {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Pessoa contato = meusContatos.buscarContato("André");
		assertEquals("O nome atual é: ", "André", contato.getNome());
		meusContatos.atualizarContato(contato, "Maria", "Moreira", "1937-8246", "maria@hotmail.com", "Cozinheira", data.parse("02/09/1957"));
		assertEquals("O nome atualizado é: ", "Maria", contato.getNome());
	}
	
	@Test
	public void testRemoveContato() {
		Pessoa contato = meusContatos.buscarContato("Leonardo");
		assertEquals("O Leonardo está na agenda? ", true, contato != null && contato.getNome()=="Leonardo"?true:false);
		boolean resultado = meusContatos.removerContato("Leonardo");
		assertEquals("O Leonardo foi apagado? ", true, resultado);
	}
	
	@Test
	public void testBuscarContato() {
		Pessoa contato = meusContatos.buscarContato("Maria");
		assertEquals("A Maria está na agenda? ", false, contato != null && contato.getNome()=="Maria"?true:false);
		Pessoa contato2 = meusContatos.buscarContato("Larissa");
		assertEquals("A Larissa está na agenda? ", true, contato2 != null && contato2.getNome()=="Larissa"?true:false);
	}
}
