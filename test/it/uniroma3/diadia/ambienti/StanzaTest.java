package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanza;
	private Stanza stanzaVuota;
	private Stanza stanzaIsolata;
	private Stanza stanzaNord;
	private Stanza stanzaSud;
	private Stanza stanzaEst;
	private Stanza stanzaOvest;
	private Attrezzo osso;
	private Attrezzo spada;	
    
    @Before
    public void setUp() {
        this.stanza = new Stanza("stanza");
        this.stanzaVuota =new Stanza("stanzaVuota");
        this.stanzaIsolata=new Stanza("stanzaIsolata");
        this.stanzaNord=new Stanza("stanzaNord");
        this.stanzaSud=new Stanza("stanzaSud");
        this.stanzaEst=new Stanza("stanzaEst");
        this.stanzaOvest=new Stanza("stanzaOvest");     
        this.osso=new Attrezzo("osso",1);
        this.spada=new Attrezzo("spada",7);
        this.stanza.addAttrezzo(osso);
        this.stanza.addAttrezzo(spada);
        this.stanza.impostaStanzaAdiacente("nord", this.stanzaNord);
        this.stanza.impostaStanzaAdiacente("sud", this.stanzaSud);
        this.stanza.impostaStanzaAdiacente("est", this.stanzaEst);
        this.stanza.impostaStanzaAdiacente("ovest", this.stanzaOvest);
        this.stanzaVuota.impostaStanzaAdiacente("nord", this.stanzaNord);
        this.stanzaVuota.impostaStanzaAdiacente("sud", this.stanzaSud);
        this.stanzaVuota.impostaStanzaAdiacente("est", this.stanzaEst);
        this.stanzaVuota.impostaStanzaAdiacente("ovest", this.stanzaOvest);
        this.stanzaIsolata.addAttrezzo(osso);
        this.stanzaIsolata.addAttrezzo(spada);
    }
    
    @Test
    public void testGetNomeStanza() {
        assertEquals("stanza", this.stanza.getNome());
    }
    
    @Test
    public void testGetNomeStanzaVuota() {
        assertEquals("stanzaVuota", this.stanzaVuota.getNome());
    }
    
    @Test
    public void testGetNomeStanzaIsolata() {
        assertEquals("stanzaIsolata", this.stanzaIsolata.getNome());
    }
    
    @Test
    public void testGetStanzaAdiacenteStanza() {
 //   	this.stanza=new Stanza("stanza");
//    	Stanza stanzaNord=new Stanza("stanzaNord");
 //   	this.stanza.impostaStanzaAdiacente("nord", stanzaNord);
        assertEquals(this.stanzaNord, this.stanza.getStanzaAdiacente("nord"));
    }
    
    @Test
    public void testGetStanzaAdiacenteStanzaVuota() {
        assertEquals(this.stanzaSud, this.stanzaVuota.getStanzaAdiacente("sud"));
    }
    
    @Test
    public void testGetStanzaAdiacenteStanzaIsolata() {
        assertEquals(null, this.stanzaIsolata.getStanzaAdiacente("est"));
    }
    
    @Test
    public void testGetAttrezzoStanza() {
        assertEquals(osso, this.stanza.getAttrezzo("osso"));
    }
    
    @Test
    public void testGetAttrezzoStanzaVuota() {
        assertEquals(null, this.stanzaVuota.getAttrezzo("osso"));
    }
    
    @Test
    public void testGetAttrezzoStanzaIsolata() {
        assertEquals(osso, this.stanzaIsolata.getAttrezzo("osso"));
    }
    
    @Test
    public void testHasAttrezzoStanza() {
        assertEquals(true, this.stanza.hasAttrezzo("osso"));
        assertEquals(false, this.stanza.hasAttrezzo("ascia"));
    }
    
    public void testHasAttrezzoStanzaVuota() {
        assertEquals(false, this.stanzaVuota.hasAttrezzo("osso"));
    }
    
    public void testHasAttrezzoIsolata() {
        assertEquals(true, this.stanzaIsolata.hasAttrezzo("osso"));
        assertEquals(false, this.stanzaIsolata.hasAttrezzo("ascia"));
    }
    
    @Test
    public void testRemoveAttrezzoStanza() {
    	Attrezzo ascia=new Attrezzo("ascia",5);
        assertEquals(true, this.stanza.removeAttrezzo(osso));
        assertEquals(false, this.stanza.removeAttrezzo(ascia));
    }
    
    public void testRemoveAttrezzoStanzaVuota() {
        assertEquals(false, this.stanzaVuota.removeAttrezzo(osso));
    }
    
    public void testRemoveAttrezzoIsolata() {
    	Attrezzo ascia=new Attrezzo("ascia",5);
        assertEquals(true, this.stanzaIsolata.removeAttrezzo(osso));
        assertEquals(false, this.stanzaIsolata.removeAttrezzo(ascia));
    }
}
