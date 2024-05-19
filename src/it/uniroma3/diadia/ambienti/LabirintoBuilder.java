package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto{
	private String stanzaIniziale;
	private String stanzaVincente;
	private Map<String, Stanza> stanze;
	private Map<String, Attrezzo> attrezzi;
	private String ultimaAggiunta;


	public Stanza getStanzaVincente() {
		return stanze.get(stanzaVincente);
	}

	public void setStanzaVincente(String nome) {
		this.stanzaVincente=nome;
	}

	public void setStanzaIniziale(String nome) {
		this.stanzaIniziale=nome;
	}



	public Stanza getStanzaIniziale() {
		return stanze.get(stanzaIniziale);
	}


	public LabirintoBuilder() {
		this.stanze = new HashMap<>();
		this.attrezzi = new HashMap<>();
	}

	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza app=new Stanza(nomeStanza);
		this.stanzaIniziale=nomeStanza;
		if(!stanze.containsKey(nomeStanza)) {
			this.stanze.put(nomeStanza, app);     
		}
		this.ultimaAggiunta=nomeStanza;
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza app=new Stanza(nomeStanza);
		if(!stanze.containsKey(nomeStanza)) {
			this.stanze.put(nomeStanza, app);
		}
		this.stanzaVincente=nomeStanza;
		this.ultimaAggiunta=nomeStanza;
		return this;
	}

	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		if(!stanze.containsKey(nomeStanza)) {
			this.stanze.put(nomeStanza, stanza);
		}
		this.ultimaAggiunta=nomeStanza;
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nomeStanza,String luce) {
		Stanza stanza = new StanzaBuia(nomeStanza,luce);
		this.stanze.put(nomeStanza, stanza);
		this.ultimaAggiunta=nomeStanza;
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nomeStanza,String direzione,String apriporta) {
		Stanza stanza = new StanzaBloccata(nomeStanza,direzione,apriporta);
		this.stanze.put(nomeStanza, stanza);
		this.ultimaAggiunta=nomeStanza;
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nomeStanza,int soglia) {
		Stanza stanza = new StanzaMagica(nomeStanza,soglia);
		this.stanze.put(nomeStanza, stanza);
		this.ultimaAggiunta=nomeStanza;
		return this;
	}


	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo attrezzo=new Attrezzo(nomeAttrezzo, peso);
		this.stanze.get(ultimaAggiunta).addAttrezzo(attrezzo);
		attrezzi.put(this.ultimaAggiunta, attrezzo);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanzaDa, String stanzaA, String direzione) {
		if(stanze.get(stanzaDa).getDirezioni().size()==4||stanze.get(stanzaA).getDirezioni().size()==4)return this;
		stanze.get(stanzaDa).impostaStanzaAdiacente(direzione,stanze.get(stanzaA));
		return this;
	}

	public Labirinto getLabirinto() {
		return this;
	}

	public Map<String,Stanza> getListaStanze() {				
		return this.stanze;

	}
}
