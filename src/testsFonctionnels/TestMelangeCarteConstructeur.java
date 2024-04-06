package testsFonctionnels;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.*;

public class TestMelangeCarteConstructeur {

	public static void main(String[] args) {
		List<Carte> listeCartesRef = new ArrayList<>();
		JeuDeCartes jeu = new JeuDeCartes();
		for (Carte c : jeu.getTypeCarte()) {
			for (int i = 0; i < c.getNombre(); i++) {
				listeCartesRef.add(c);
			}
		}
		System.out.println(Utils.verifierMelange(listeCartesRef, jeu.getListeCartes()));

	}

}