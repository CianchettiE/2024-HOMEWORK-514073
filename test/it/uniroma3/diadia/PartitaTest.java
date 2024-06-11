package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	private Partita game1;      //Invoca creaStanze();
	private Stanza biblioteca;
	private Stanza aula1;


	@Before
	public void setUp() throws Exception {
		game1= new Partita();      //Invoca creaStanze();
		biblioteca = new Stanza("Biblioteca");
		aula1= new Stanza("aula1");

	}
	
    @Test
    public void testGetStanzaCorrenteDefault() {
    	assertEquals("atrio", game1.getStanzaCorrente().getNome());
    }
    @Test
    public void testGetStanzaCorrente() {
    	game1.setStanzaCorrente(aula1);
    	assertSame(aula1, game1.getStanzaCorrente());
    }
	
	@Test
	public void testGetStanzaVincenteDefault() {
		/*AssertSame fallirebbe, riferimenti ad oggetti diversi*/
		assertEquals("biblioteca",game1.getStanzaVincente().getNome());
	}
	
	
	public void testVintaStanzaNonVincente() {
		game1.setStanzaCorrente(aula1);
		assertFalse(game1.vinta());
	}

	
	public void testIsFinitaStanzaNonVincente() {
		game1.setStanzaCorrente(aula1);
		assertFalse(game1.isFinita());
	}
	
	public void testIsFinitaCfu() {
		game1.setCfu(0);
		assertTrue(game1.isFinita());
	} 
	@Test
	public void testGetCfuDefault() {
		assertEquals(20,game1.getCfu());
	}
	
	@Test
	public void testGetCfuModificati() {
		game1.setCfu(22);
		assertEquals(22,game1.getCfu());
	}
}