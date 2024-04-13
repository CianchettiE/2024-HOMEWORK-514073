package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Borsa borsa;
	private Borsa borsaVuota;
	private Borsa borsaPiena;
	private Attrezzo attrezzoprova;

	@Before
	public void setUp() {
		this.borsa=new Borsa();
		this.borsaVuota=new Borsa();
		this.borsaPiena=new Borsa();
		this.attrezzoprova=new Attrezzo("attrezzoprova",1);
		this.borsa.addAttrezzo(attrezzoprova);
		for(int i=0;i<10;i++) {
			this.borsaPiena.addAttrezzo(attrezzoprova);
		}	

	}

	@Test
	public void testAddAttrezzoBorsa() {
		assertEquals(true,this.borsa.addAttrezzo(attrezzoprova));
	}

	@Test
	public void testAddAttrezzoBorsaPiena() {
		assertEquals(false,this.borsaPiena.addAttrezzo(attrezzoprova));
	}

	@Test
	public void testAddAttrezzoBorsaVuota() {
		assertEquals(true,this.borsaVuota.addAttrezzo(attrezzoprova));
	}

	@Test
	public void testGetPesoMaxBorsa() {
		assertEquals(10,this.borsa.getPesoMax());
	}

	@Test
	public void testGetAttrezzoBorsa() {
		assertEquals(this.attrezzoprova,this.borsa.getAttrezzo("attrezzoprova"));
	}

	@Test
	public void testGetAttrezzoBorsaPiena() {
		assertEquals(this.attrezzoprova,this.borsaPiena.getAttrezzo("attrezzoprova"));
	}

	@Test
	public void testGetAttrezzoBorsaVuota() {
		assertEquals(null,this.borsaVuota.getAttrezzo("attrezzoprova"));
	}

	@Test
	public void testGetPesoBorsa() {
		assertEquals(1,this.borsa.getPeso());
	}

	@Test
	public void testGetPesoBorsaPiena() {
		assertEquals(10,this.borsaPiena.getPeso());
	}

	@Test
	public void testGetPesoBorsaVuota() {
		assertEquals(0,this.borsaVuota.getPeso());
	}

	@Test
	public void testIsEmptyBorsa() {
		assertEquals(false,this.borsa.isEmpty());
	}

	@Test
	public void testIsEmptyBorsaVuota() {
		assertEquals(true,this.borsaVuota.isEmpty());
	}

	@Test
	public void testHasAttrezzoBorsa() {
		assertEquals(true, this.borsa.hasAttrezzo("attrezzoprova"));
		assertEquals(false, this.borsa.hasAttrezzo("ascia"));
	}

	@Test
	public void testHasAttrezzoBorsaVuota() {
		assertEquals(false, this.borsaVuota.hasAttrezzo("attrezzoprova"));
		assertEquals(false, this.borsaVuota.hasAttrezzo("ascia"));
	}
	
	@Test
    public void testRemoveAttrezzoBorsa() {
        assertEquals(attrezzoprova, this.borsa.removeAttrezzo("attrezzoprova"));
        assertEquals(true,this.borsa.isEmpty());
    }
	
	@Test
    public void testRemoveAttrezzoBorsaVuota() {
        assertEquals(null, this.borsaVuota.removeAttrezzo("attrezzoprova"));
    }
	
	@Test
    public void testRemoveAttrezzoPiena() {
        assertEquals(attrezzoprova, this.borsaPiena.removeAttrezzo("attrezzoprova"));
        assertEquals(false,this.borsaPiena.isEmpty());
    }
}
