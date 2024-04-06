package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{

	private int nbCartes = 0;
	private Carte[] sabot;
	private int nbOperations = 0;

	public Sabot() {
		this.sabot= new Carte[110];
	}

	public int getNbCartes() {
		return nbCartes;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}

	private void ajouterCarte(Carte carte) throws IllegalStateException {
		if (nbCartes == sabot.length) {
			throw new IllegalStateException();
		}
		sabot[nbCartes] = carte;
		nbCartes++;
		nbOperations++;
	}

	private void ajouterFamilleCarte(Carte carte){
		for(int i=0;i<carte.getNombre();i++) {
			ajouterCarte(carte);
		}
	}

	public void ajouterFamilleCarte(Carte... carte) {
		for (int i = 0; i < carte.length; i++) {
			ajouterFamilleCarte(carte[i]);
		}
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iter();
	}

	private class Iter implements Iterator<Carte>{

		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nombreOperationsReference = nbOperations;		

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte cartes = sabot[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return cartes;
			} else {
				throw new NoSuchElementException();
			}
		}
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				sabot[i] = sabot[i + 1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			nbOperations++;
			nombreOperationsReference++;
		}

		private void verificationConcurrence(){
			if (nbOperations != nombreOperationsReference)
				throw new ConcurrentModificationException();
		}

	}
	
	public Carte piocher() {
		Iter iterateur = new Iter();
		if (iterateur.hasNext()) {
			Carte carte = iterateur.next();
			iterateur.remove();
			System.out.println("Je pioche " + carte.toString());
			return carte;
		}
		throw new NoSuchElementException();
	}


}
