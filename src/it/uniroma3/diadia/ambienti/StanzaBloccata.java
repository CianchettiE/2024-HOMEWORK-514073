package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String apriPorta;

	public StanzaBloccata(String nome,String direzione,String apriPorta) {
		super(nome);
		this.direzioneBloccata=direzione;
		this.apriPorta=apriPorta;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		
		if(!this.direzioneBloccata.equals(direzione)||this.hasAttrezzo(apriPorta)) {
			return super.getStanzaAdiacente(direzione);
		}
		return null;
	}
	
	@Override
	public String getDescrizione() {
		return (super.getDescrizione() + "\nla direzione "+this.direzioneBloccata+" è bloccata");
		
	}

}
