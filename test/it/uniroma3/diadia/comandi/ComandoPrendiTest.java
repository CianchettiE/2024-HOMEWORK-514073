package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPrendiTest {
    private Partita partita;
    private Stanza stanzaCorrente;
    private ComandoPrendi comandoPrendi;
    private IOConsole io;

    @Before
    public void setUp() {
    	this.io=new IOConsole();
        partita = new Partita();
        stanzaCorrente = new Stanza("Stanza di test");
        partita.setStanzaCorrente(stanzaCorrente);
        comandoPrendi = new ComandoPrendi("martello");
    }

    @Test
    public void testPrendiAttrezzoPresenteInStanza() {
        Attrezzo martello = new Attrezzo("martello", 2);
        stanzaCorrente.addAttrezzo(martello);
        comandoPrendi.esegui(partita,io);
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
        assertFalse(stanzaCorrente.hasAttrezzo("martello"));
    }

    @Test
    public void testPrendiAttrezzoNonPresenteInStanza() {
        comandoPrendi.esegui(partita,io);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }

    @Test
    public void testPrendiAttrezzoConNomeNullo() {
        ComandoPrendi comandoPrendiSenzaNome = new ComandoPrendi(null);
        comandoPrendiSenzaNome.esegui(partita,io);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }
}

