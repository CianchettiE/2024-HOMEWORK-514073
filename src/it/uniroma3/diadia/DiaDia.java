package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

//import java.util.Scanner;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO io;
	private FabbricaDiComandi fabbricaDiComandi;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io=io;
		this.fabbricaDiComandi= new FabbricaDiComandiFisarmonica();
	}

	public DiaDia(Labirinto labirinto,IO io) {
		this.partita = new Partita(labirinto);
		this.io=io;
		this.fabbricaDiComandi= new FabbricaDiComandiFisarmonica();
	}

	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());		
		do
			istruzione=io.leggiRiga();
		while (!processaIstruzione(istruzione));		
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		if(istruzione.isEmpty()) return false;
		Comando comandoDaEseguire =this.fabbricaDiComandi.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita,io);
		if(istruzione.equals("fine"))return true;
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;

	}   

	public static void main(String[] argc) {
		IO io=new IOConsole();	
		LabirintoBuilder labirinto=new LabirintoBuilder();
		labirinto.addStanzaMagica("Atrio",3);
		labirinto.setStanzaIniziale("Atrio");
		labirinto.addAttrezzo("spada", 5).addAttrezzo("spada", 5);
		labirinto.addStanzaBuia("AulaN10","lanterna");
		labirinto.addAttrezzo("chiave", 1);
		labirinto.addAttrezzo("lanterna", 3);
		labirinto.addStanzaBloccata("AulaN11","est","chiave");
		labirinto.addAttrezzo("spada", 5);
		labirinto.addStanzaVincente("Biblioteca");
		labirinto.addStanza("Laboratorio");
		labirinto.addAdiacenza("Atrio", "Biblioteca", "nord");
		labirinto.addAdiacenza("Atrio", "AulaN11", "est");
		labirinto.addAdiacenza("Atrio", "AulaN10", "sud");
		labirinto.addAdiacenza("Atrio", "Laboratorio", "ovest");
		labirinto.addAdiacenza("AulaN11", "Laboratorio", "est");
		labirinto.addAdiacenza("AulaN11", "Atrio", "ovest");
		labirinto.addAdiacenza("AulaN10", "Atrio", "nord");
		labirinto.addAdiacenza("AulaN10", "AulaN11", "est");
		labirinto.addAdiacenza("AulaN10", "Laboratorio", "ovest");
		labirinto.addAdiacenza("Laboratorio", "Atrio","est");
		labirinto.addAdiacenza("Laboratorio", "AulaN11", "ovest");
		labirinto.addAdiacenza("Biblioteca", "Atrio", "sud");
		DiaDia gioco = new DiaDia(labirinto,io);
		gioco.gioca();
	}
}
