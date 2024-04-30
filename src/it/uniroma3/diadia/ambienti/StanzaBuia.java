package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String fonteLuce;

	public StanzaBuia(String nome,String luce) {
		super(nome);
		this.fonteLuce=luce;
	}

	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(this.fonteLuce)) {
			return super.getDescrizione();
		}
		else
			return "qui c'è un buio pesto";
	}
}
