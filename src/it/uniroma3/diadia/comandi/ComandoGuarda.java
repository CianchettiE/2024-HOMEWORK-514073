package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita,IO io) {
		// TODO Auto-generated method stub
		io.mostraMessaggio("la stanza corrente è:\n");
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("nella borsa sono presenti i seguenti oggetti:\n");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome().toString());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		return "guarda";
		
	}

	@Override
	public String getParametro() {
		return null;
		
	}

}
