package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
private String nomeAttrezzo;
	
	public ComandoPosa(String attrezzo) {
		this.nomeAttrezzo=attrezzo;
	}
	
	@Override
	public void esegui(Partita partita,IO io) {
		// TODO Auto-generated method stub
		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			io.mostraMessaggio("l'oggetto è stato posato nella stanza");
		}
		else {
			io.mostraMessaggio("l'oggetto non è presente nella borsa");
		}

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo=parametro;

	}

	@Override
	public String getNome() {
		return "posa";
		
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
		
	}

}
