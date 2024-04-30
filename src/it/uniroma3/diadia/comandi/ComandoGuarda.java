package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita,IO io) {
		// TODO Auto-generated method stub
		io.mostraMessaggio("la stanza corrente è:\n");
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
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
