package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	
	public ComandoPrendi(String attrezzo) {
		this.nomeAttrezzo=attrezzo;
	}

	@Override
	public void esegui(Partita partita,IO io) {
		// TODO Auto-generated method stub
		if(this.nomeAttrezzo==null) {
			io.mostraMessaggio("Quale attrezzo vuoi prendere?\n");
			return;
		}
		if(partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo)) {
			Attrezzo a=null;
			a=partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(partita.getGiocatore().getBorsa().getPeso()+a.getPeso()>partita.getGiocatore().getBorsa().getPesoMax()) {
				io.mostraMessaggio("l'oggetto è troppo pesante");
				return;
			}
			partita.getGiocatore().getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo));
			partita.getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("l'oggetto è stato aggiunto alla borsa");
		}
		else {
			io.mostraMessaggio("l'oggetto non è presente nella stanza");
		}

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo=parametro;
	}

	@Override
	public String getNome() {
		return "prendi";
		
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
		
	}

}
