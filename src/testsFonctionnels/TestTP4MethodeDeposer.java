package testsFonctionnels;

import java.util.List;
import cartes.*;
import cartes.Probleme.Type;
import jeu.*;

public class TestTP4MethodeDeposer implements Cartes{

		public static void main(String[] args) {
			// Cr�ation d'un joueur
			Joueur joueur = new Joueur("Joueur 1");

			// Cr�ation de diff�rentes cartes
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
			
			// Test de d�p�t de diff�rentes cartes
			System.out.println("d�poser feu rouge : d�p�t ok ? " + joueur.deposer(rouge) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser accident : d�p�t ok ? " + joueur.deposer(accident) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser as du volant : d�p�t ok ? " + joueur.deposer(asDuVolant) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser panne essence : d�p�t ok ? " + joueur.deposer(panneEssence) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser essence : d�p�t ok ? " + joueur.deposer(panneEssence) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser feu vert : d�p�t ok ? " + joueur.deposer(vert) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser 100 : d�p�t ok ? " + joueur.deposer(borne100) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser limite: d�p�t ok ? " + joueur.deposer(limite) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser 100 : d�p�t ok ? " + joueur.deposer(borne100) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser 25 : d�p�t ok ? " + joueur.deposer(borne25) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser fin limite : d�p�t ok ? " + joueur.deposer(finLimite) + ", bloqu� ? " + joueur.estBloque());
			System.out.println("d�poser 100 : d�p�t ok ? " + joueur.deposer(borne100) + ", bloqu� ? " + joueur.estBloque());
		}
	
}
