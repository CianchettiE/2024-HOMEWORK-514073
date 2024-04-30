package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;

	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita,IO io) {
		Stanza stanzaCorrente=partita.getStanzaCorrente();
		Stanza prossimaStanza=null;
		if(direzione==null) {
			io.mostraMessaggio("Dove voui andare? \n Devi spevificare una direzione\n");
			return;
		}
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente\n");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}

	@Override
	public String getNome() {
		return "vai";
		
	}

	@Override
	public String getParametro() {
		return this.direzione;
		
	}
}
