package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class GiocatoreTest {
	private Giocatore giocatore;
	private int Cfu;
	
	@Before
	public void setUp() {
		this.Cfu=10;
		this.giocatore=new Giocatore();
		this.giocatore.setCfu(Cfu);
		
	}

	@Test
	public void testGetCfu() {
		assertEquals(this.Cfu,this.giocatore.getCfu());		
	}
	
	@Test
	public void testGetBorsa() {
		assertEquals(new Borsa(),this.giocatore.getBorsa());		
	}
	

}
