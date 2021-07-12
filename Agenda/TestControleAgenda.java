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
		meusContatos.adicionarContato("Maria", "Moreira", "2865-9751", "maria@hotmail.com", "Cozinheira", data.parse("02/02/1957"));
	}
	
	
	@Test
	public void testListagemContatos() {
		assertEquals("Quantidade de pessoas na agenda: ", 5, meusContatos.listarContatos().size());
		assertEquals("O terceiro nome da agenda: ", "Alessandra", meusContatos.listarContatos().get(2).getNome());	
		assertEquals("A profissão da quinta pessoa da agenda: ", "Cozinheira", meusContatos.listarContatos().get(4).getProfissao());		
	}
	
	
	@Test
	public void testAtualizarContato() throws ParseException {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Pessoa contato = meusContatos.buscarContato("André");
		assertEquals("O nome atual é: ", "André", contato.getNome());
		meusContatos.atualizarContato(contato, "Carlos", "Rodrigues", "1937-8246", "carlos@hotmail.com", "Torneiro", data.parse("30/03/1956"));
		assertEquals("O nome atualizado é: ", "Carlos", contato.getNome());
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
		Pessoa contato = meusContatos.buscarContato("Carlos");
		assertEquals("O Carlos está na agenda? ", false, contato != null && contato.getNome()=="Maria"?true:false);
		Pessoa contato2 = meusContatos.buscarContato("Larissa");
		assertEquals("A Larissa está na agenda? ", true, contato2 != null && contato2.getNome()=="Larissa"?true:false);
	}
}
