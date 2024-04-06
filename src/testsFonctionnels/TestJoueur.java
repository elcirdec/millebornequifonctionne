package testsFonctionnels;

import java.util.List;

import cartes.*;
import jeu.*;

public class TestJoueur {
	public static void main(String[] args) {
		Joueur joueur = new Joueur("J1");
		System.out.println("Avant ajout : "+joueur.donnerKmParcourus());
		Borne b1 = new Borne(100,1);
		joueur.deposer(b1);
		System.out.println("Apres ajout de 100 : "+joueur.donnerKmParcourus());
		Borne b2 = new Borne(100,1);
		Borne b3 = new Borne(25,1);
		joueur.deposer(b2);
		joueur.deposer(b3);
		System.out.println("Apres ajout de 100 et 25 : "+joueur.donnerKmParcourus());
	}
}
