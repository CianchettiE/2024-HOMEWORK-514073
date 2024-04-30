package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita,IO io) {
		// TODO Auto-generated method stub
		io.mostraMessaggio("il comando non è valido\n");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		return null;
		
	}

	@Override
	public String getParametro() {
		return null;
		
	}

}
