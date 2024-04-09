package testsFonctionnels;

import java.util.List;
import cartes.*;
import cartes.Probleme.Type;
import jeu.*;

public class TestTP4MethodeDeposer implements Cartes{

		public static void main(String[] args) {
			// Création d'un joueur
			Joueur joueur = new Joueur("Joueur 1");

			// Création de différentes cartes
			Carte borne100 = new Borne(100,1);
			Carte borne25 = new Borne(25,1);
			Carte limite = new DebutLimite(1);
			Carte finLimite = new FinLimite(1);
			Carte accident = new Attaque(1, Type.ACCIDENT);
			Carte panneEssence = new Attaque(1, Type.ESSENCE);
			Carte essence = new Parade(1, Type.ESSENCE);
			Carte asDuVolant = new Botte(1, Type.ACCIDENT);
			Carte vert =   new Parade(1,Type.FEU);
			Carte rouge =  new Attaque(1,Type.FEU);
			
			// Test de dépôt de différentes cartes
			System.out.println("déposer feu rouge : dépôt ok ? " + joueur.deposer(rouge) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer accident : dépôt ok ? " + joueur.deposer(accident) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer as du volant : dépôt ok ? " + joueur.deposer(asDuVolant) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer panne essence : dépôt ok ? " + joueur.deposer(panneEssence) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer essence : dépôt ok ? " + joueur.deposer(panneEssence) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer feu vert : dépôt ok ? " + joueur.deposer(vert) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer 100 : dépôt ok ? " + joueur.deposer(borne100) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer limite: dépôt ok ? " + joueur.deposer(limite) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer 100 : dépôt ok ? " + joueur.deposer(borne100) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer 25 : dépôt ok ? " + joueur.deposer(borne25) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer fin limite : dépôt ok ? " + joueur.deposer(finLimite) + ", bloqué ? " + joueur.estBloque());
			System.out.println("déposer 100 : dépôt ok ? " + joueur.deposer(borne100) + ", bloqué ? " + joueur.estBloque());
		}
	
}
