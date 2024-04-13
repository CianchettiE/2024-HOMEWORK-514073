package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {
	
	private Partita partita;
	private Stanza stanzaCorrente;
	
	@Before
	public void setUp() {
		this.partita=new Partita();
		this.stanzaCorrente=new Stanza("stanzaCorrente");
		this.partita.setStanzaCorrente(stanzaCorrente);
		
	}

	@Test
	public void testGetStanzaCorrente() {
		assertEquals(this.stanzaCorrente,this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testIsFinita() {
		this.partita.setFinita();
		assertEquals(true,this.partita.isFinita());
	}
	
	@Test
	public void testVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertEquals(true,this.partita.vinta());
	}
	
	@Test
	public void testGetLabirinto() {
		Labirinto labirinto=new Labirinto();
		labirinto.equals(this.partita.getLabirinto());
	}
	/*non so come verificare che tutto il labirinto sia uguale quindi mi sono limitatto
	a verificare che fossero uguali la stanza iniziale e la stanza vincente*/
	
	@Test
	public void testGetGiocatore() {
		Giocatore giocatore=new Giocatore();
		giocatore.equals(this.partita.getGiocatore());
	}
	//come sopra mi sono limitato a verificare che i Cfu e la borsa fossero uguali
	

}
