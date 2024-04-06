package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainAsListe implements IMain{
	
	List<Carte> carteListe = new ArrayList<>();
	
	@Override
	public Iterator<Carte> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prendre(Carte carte) {
		carteListe.add(carte);
		
	}

	@Override
	public void jouer(Carte carte) {
		if(!carteListe.contains(carte)) {
			throw new IllegalArgumentException();
		}
		carteListe.remove(carte);
		
	}
	
	@Override
	public String toString() {
		return carteListe.toString();
	}
	
	
	
	
	

}
