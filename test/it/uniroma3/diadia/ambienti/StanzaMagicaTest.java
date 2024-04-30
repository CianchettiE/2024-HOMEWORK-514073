package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaMagicaTest {
	private StanzaMagica stanzaMagica;
	

	@Before
	public void setUp() {
		stanzaMagica = new StanzaMagica("Stanza Magica", 2);
		
	}

	@Test
	public void testAddAttrezzoSottoSogliaMagica() {
		Attrezzo attrezzo = new Attrezzo("martello", 2);
		assertTrue(stanzaMagica.addAttrezzo(attrezzo));
		assertTrue(stanzaMagica.hasAttrezzo("martello"));
	}

	@Test
	public void testAddAttrezzoSopraSogliaMagica() {
		Attrezzo attrezzo1 = new Attrezzo("martello", 2);
		Attrezzo attrezzo2 = new Attrezzo("chiave", 3);
		Attrezzo attrezzo3 = new Attrezzo("libro", 1);
		assertTrue(stanzaMagica.addAttrezzo(attrezzo1));
		assertTrue(stanzaMagica.addAttrezzo(attrezzo2));
		assertTrue(stanzaMagica.addAttrezzo(attrezzo3));
		assertTrue(stanzaMagica.hasAttrezzo("martello"));
		assertTrue(stanzaMagica.hasAttrezzo("orbil"));
		assertEquals(2, stanzaMagica.getAttrezzo("orbil").getPeso());
	}

	
}




