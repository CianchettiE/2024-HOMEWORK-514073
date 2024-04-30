package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
    private StanzaBuia stanzaBuia;
    private Stanza stanza;

    @Before
    public void setUp() {
        stanzaBuia = new StanzaBuia("Stanza Buia", "lanterna");
        this.stanza=stanzaBuia;
    }

    @Test
    public void testGetDescrizioneConLuce() {
        Attrezzo lanterna = new Attrezzo("lanterna", 1);
        stanzaBuia.addAttrezzo(lanterna);
        assertEquals(stanza.getDescrizione(), stanzaBuia.getDescrizione());
    }

    @Test
    public void testGetDescrizioneSenzaLuce() {
        assertEquals("qui c'è un buio pesto", stanzaBuia.getDescrizione());
    }
}

