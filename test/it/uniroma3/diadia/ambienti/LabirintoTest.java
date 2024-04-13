package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	@Before
	    public void setUp() {
		this.labirinto=new Labirinto();
		this.stanzaIniziale=new Stanza("Atrio");
		this.stanzaVincente=new Stanza("Biblioteca");
		 
	 }
	

	@Test
	public void testGetStanzaInizialeLabirinto() {
		assertEquals(this.stanzaIniziale,labirinto.getStanzaIniziale());
	}
//per il momento ho considerato due stanze uguali due stanze con lo stesso nome
	@Test
	public void testGetStanzaVincenteLabirinto() {
		assertEquals(this.stanzaVincente,labirinto.getStanzaVincente());
	}
}
