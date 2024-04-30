package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPosaTest {
    private Partita partita;
    private Stanza stanzaCorrente;
    private ComandoPosa comandoPosa;
    private IO io;

    @Before
    public void setUp() {
    	this.io=new IOConsole();
        partita = new Partita();
        stanzaCorrente = new Stanza("Stanza di test");
        partita.setStanzaCorrente(stanzaCorrente);
        comandoPosa = new ComandoPosa("martello");
    }

    

    @Test
    public void testPosaAttrezzoPresenteInBorsa() {
        Attrezzo martello = new Attrezzo("martello", 2);
        partita.getGiocatore().getBorsa().addAttrezzo(martello);
        comandoPosa.esegui(partita,io);
        assertTrue(stanzaCorrente.hasAttrezzo("martello"));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }

    @Test
    public void testPosaAttrezzoNonPresenteInBorsa() {
        comandoPosa.esegui(partita,io);
        assertFalse(stanzaCorrente.hasAttrezzo("martello"));
    }
}

