package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	private Borsa borsa;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Borsa ordinata;
	private Attrezzo piombo;
	private Attrezzo ps;
	private Attrezzo piuma;
	private Attrezzo libro;

	@Before
	public void setUp() {
		borsa = new Borsa();
		attrezzo1 = new Attrezzo("attrezzo1", 2);
		attrezzo2 = new Attrezzo("attrezzo2", 3);
		attrezzo3 = new Attrezzo("attrezzo3", 5);
		this.piuma=new Attrezzo("piuma",1);
		this.piombo=new Attrezzo("piombo",10);
		this.ps=new Attrezzo("ps",5);
		this.libro=new Attrezzo("libro",5);
		this.ordinata=new Borsa();
		this.ordinata.addAttrezzo(piombo);
		this.ordinata.addAttrezzo(ps);
		this.ordinata.addAttrezzo(piuma);
		this.ordinata.addAttrezzo(libro);
	}

	@Test
	public void testBorsaVuota() {
		assertTrue(borsa.isEmpty());
		assertEquals(0, borsa.getPeso());
		assertNull(borsa.getAttrezzo("attrezzo1"));
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(borsa.addAttrezzo(attrezzo1));
		assertFalse(borsa.isEmpty());
		assertEquals(2, borsa.getPeso());
		assertNotNull(borsa.getAttrezzo("attrezzo1"));
		assertTrue(borsa.addAttrezzo(attrezzo2));
		assertTrue(borsa.addAttrezzo(attrezzo3));
		assertEquals(10, borsa.getPeso());
	}

	@Test
	public void testRemoveAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		borsa.addAttrezzo(attrezzo3);
		assertEquals(10, borsa.getPeso());
		Attrezzo removed = borsa.removeAttrezzo("attrezzo2");
		assertNotNull(removed);
		assertEquals("attrezzo2", removed.getNome());
		assertEquals(7, borsa.getPeso());
		assertNull(borsa.removeAttrezzo("attrezzo4"));
	}

	@Test
	public void testGetAttrezzi() {
		List<Attrezzo> attrezzi = new ArrayList<>();
		attrezzi.add(attrezzo1);
		attrezzi.add(attrezzo2);
		attrezzi.add(attrezzo3);
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		borsa.addAttrezzo(attrezzo3);
		assertEquals(attrezzi, borsa.getAttrezzi());
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		List<Attrezzo> attrezzi = new ArrayList<>();
		attrezzi.add(attrezzo1);
		attrezzi.add(attrezzo2);
		attrezzi.add(attrezzo3);
		borsa.addAttrezzo(attrezzo3);
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		assertEquals(attrezzi, borsa.getContenutoOrdinatoPerPeso());
	}

	@Test
	public void testGetContenutoOrdinatoPerNome() {
		List<Attrezzo> attrezzi = new ArrayList<>();
		attrezzi.add(attrezzo1);
		attrezzi.add(attrezzo2);
		attrezzi.add(attrezzo3);
		borsa.addAttrezzo(attrezzo3);
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		assertEquals(attrezzi, new ArrayList<>(borsa.getContenutoOrdinatoPerNome()));
	}

	/*@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> attrezziRaggruppati = borsa.getContenutoRaggruppatoPerPeso();
		assertEquals(3, attrezziRaggruppati.size());
		Set<Attrezzo> attrezziPeso3 = attrezziRaggruppati.get(3);
		assertEquals(1, attrezziPeso3.size());
		assertEquals(attrezzo3, attrezziPeso3.iterator().next());
	}*/

	@Test
	public void testEquals() {
		Borsa borsa1 = new Borsa();
		Borsa borsa2 = new Borsa();
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 2);
		Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 3);
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 5);

		// test reflexivity
		assertTrue(borsa1.equals(borsa1));

		// test symmetry
		assertTrue(borsa1.equals(borsa2) && borsa2.equals(borsa1));

		// test transitivity
		Borsa borsa3 = new Borsa();
		borsa3.addAttrezzo(attrezzo1);
		borsa3.addAttrezzo(attrezzo2);
		borsa1.addAttrezzo(attrezzo1);
		borsa1.addAttrezzo(attrezzo2);
		assertTrue(borsa1.equals(borsa3) && borsa3.equals(borsa1));

		// test null
		assertFalse(borsa1.equals(null));

		// test different classes
		assertFalse(borsa1.equals("string"));

		// test different attrezzi
		assertFalse(borsa1.equals(borsa2));
		borsa1.addAttrezzo(attrezzo1);
		borsa2.addAttrezzo(attrezzo1);
		assertFalse(borsa1.equals(borsa2));
		borsa1.addAttrezzo(attrezzo2);
		assertFalse(borsa1.equals(borsa2));
	}


}