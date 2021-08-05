package br.edu.ufabc.poo.lab9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.edu.ufabc.poo.exceptions.SaldoInsuficienteException;


public class ContaTest{
	
	private Conta contaCorrente = new ContaCorrente(300,0);
	private Conta contaEspecial = new ContaEspecial(200,100);
	private Cliente cliente = new Cliente("Larissa", 1552036587);
	
	@Test
    public void testAdicionarCliente() {
        contaCorrente.addCliente(cliente); 
        assertEquals("O primeiro cliente deve se chamar Larissa", (contaCorrente.getClientes())[0].getNome(), "Larissa");
    }
	
	@Test
	public void testSacarException() {
		
		try {
			contaCorrente.sacar(400);
	    } 
		catch (SaldoInsuficienteException e) {
			assertEquals("Saldo Insuficiente",  e.getMessage());
	    }
		
		try {
			contaEspecial.sacar(400);
	    } 
		catch (SaldoInsuficienteException e) {
			assertEquals("Saldo Insuficiente",  e.getMessage());
	    }
		
	}
	
	@Test
	public void testDepositar() {
		contaCorrente.depositar(100);
		assertEquals("O saldo atual deve ser 400", contaCorrente.getSaldo(), 400.0, 0.1);
		
		contaEspecial.depositar(100);
		assertEquals("O saldo atual deve ser 300", contaEspecial.getSaldo(), 300.0, 0.1);
	}
	
	@Test
	public void testToStringException() {
		assertTrue(contaCorrente.toString().contains("Cliente Inexistente"));
		assertTrue(contaEspecial.toString().contains("Cliente Inexistente"));
	}
	
}
