package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cartes.*;


public class Jeu {
	Set<Joueur> ensembleJoueur = new HashSet<>();
	Sabot sabot;

	public void inscrire(Joueur joueur) {
		ensembleJoueur.add(joueur);
	}
	public void remplirSabot(JeuDeCartes jeu) {
		Carte[] tabCartes = (jeu.getListeCartes()).toArray(new Carte[0]);
		sabot.ajouterFamilleCarte(tabCartes);
	}

	public void distribuerCartes() {
		for(int nbCartes=0; nbCartes<6;nbCartes++) {
			for(Iterator<Joueur> i = ensembleJoueur.iterator(); i.hasNext(); ) {
				Joueur j = (Joueur) i;
				j.donner(sabot.piocher());
			}
		}
	}

}
