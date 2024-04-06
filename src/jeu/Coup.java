package jeu;

import java.util.Objects;

import cartes.*;

public class Coup {
	private Carte carte;
	private Joueur joueur;

	public Coup(Carte carte, Joueur joueur) {
		this.carte = carte;
		this.joueur = joueur;
	}

	public boolean estValide(Joueur joueur) {
		if (carte instanceof Limite || carte instanceof Attaque){
			return this.joueur != joueur; 
		} else { 
			return true; 
		}	
	}


	@Override
	public int hashCode() {
		return 31 * (carte.hashCode()+joueur.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Coup) {
			Coup coup = (Coup) obj;
			return carte.equals(coup.getCarte())
					&& joueur.equals(coup.getJoueur());
		}
		return false;
	}

	public Carte getCarte() {
		return carte;
	}

	public Joueur getJoueur() {
		return joueur;
	}

}
