package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
    private StanzaBloccata stanzaBloccata;
    private Stanza stanza;

    @Before
    public void setUp() {
        stanzaBloccata = new StanzaBloccata("Stanza Bloccata", "nord", "chiave");
        this.stanza=stanzaBloccata;
    }

    @Test
    public void testGetDescrizione() {
        assertEquals(stanza.getDescrizione(), stanzaBloccata.getDescrizione());
    }

   
    @Test
    public void testGetStanzaAdiacentePortaChiusa() {
        assertEquals(stanza.getDescrizione(),stanzaBloccata.getStanzaAdiacente("nord")+"\nla direzione nord è bloccata");
    }

    @Test
    public void testGetStanzaAdiacentePortaAperta() {
        Attrezzo chiave = new Attrezzo("chiave", 1);
        stanzaBloccata.addAttrezzo(chiave);
        Stanza stanzaAdiacente = new Stanza("Stanza Adiacente");
        stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
        assertEquals(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("nord"));
    }
}

