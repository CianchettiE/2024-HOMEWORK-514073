package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;

	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (pesoMax < getPeso() + attrezzo.getPeso()) {
			return false;
		}
		return attrezzi.add(attrezzo);
	}

	public Attrezzo getAttrezzo(String nome) {
		for (Attrezzo attrezzo : attrezzi) {
			if (attrezzo.getNome().equals(nome)) {
				return attrezzo;
			}
		}
		return null;
	}

	public List<Attrezzo> getAttrezzi() {
		return Collections.unmodifiableList(attrezzi);
	}

	public int getPeso() {
		int peso = 0;
		for (Attrezzo attrezzo : attrezzi) {
			peso += attrezzo.getPeso();
		}
		return peso;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}

	public boolean isEmpty() {
		return attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nome) {
		return getAttrezzo(nome) != null;
	}

	public Attrezzo removeAttrezzo(String nome) {
		for (Iterator<Attrezzo> iterator = attrezzi.iterator(); iterator.hasNext();) {
			Attrezzo attrezzo = iterator.next();
			if (attrezzo.getNome().equals(nome)) {
				iterator.remove();
				return attrezzo;
			}
		}
		return null;
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> listaOrdinata = new ArrayList<>(attrezzi);
		ComparatorePerPeso cmp=new ComparatorePerPeso();
		Collections.sort(listaOrdinata,cmp);
		return listaOrdinata;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		ComparatorePerNome cmp=new ComparatorePerNome();
		SortedSet<Attrezzo> setOrdinato = new TreeSet<>(cmp);
		setOrdinato.addAll(attrezzi);
		return setOrdinato;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
	    ComparatorePerPeso cmp = new ComparatorePerPeso();
	    Map<Integer, Set<Attrezzo>> mappaAttrezzi = new HashMap<>();
	    for (Attrezzo attrezzo : attrezzi) {
	        mappaAttrezzi.computeIfAbsent(attrezzo.getPeso(), k -> new HashSet<>()).add(attrezzo);
	    }
	    return mappaAttrezzi;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "Borsa vuota";
		}
		StringBuilder sb = new StringBuilder("Contenuto borsa (total weight/max weight): ");
		for (Attrezzo attrezzo : attrezzi) {
			sb.append(attrezzo.toString());
			sb.append(" ");
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Borsa borsa = (Borsa) o;
		return pesoMax == borsa.pesoMax &&
				attrezzi.equals(borsa.attrezzi);
	}
}