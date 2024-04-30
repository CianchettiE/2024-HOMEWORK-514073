package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	static final private String[] elencoComandi = {"Puoi eseguire i seguenti comandi:\n","vai (specifica direzione),", "aiuto,", "fine,","prendi (specifica oggetto),","posa (specifica oggetto),","guarda"};

	@Override
	public void esegui(Partita partita,IO io) {
		// TODO Auto-generated method stub
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		return "aiuto";
		
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}



}
