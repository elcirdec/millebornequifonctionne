package jeu;

import java.util.*;

import cartes.*;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
	MainAsListe main;

	public Joueur(String nom) {
		this.nom=nom;
	}

	public String getNom() {
		return nom;
	}

	public Carte prendreCarte(List<Carte> sabot) {
		if(sabot.isEmpty()) {
			return null;
		}else {
			Carte carte = sabot.get((sabot.size() - 1));
			sabot.remove(carte);
			donner(carte);
			return carte;
		}

	}
	
	public Carte retirerDeLaMain(Carte carte) {
		//main.remove(carte);
		main.jouer(carte);//ca enleve la carte mais pas sur que ce sois ca qui est demander
		System.out.println("J'enleve de ma main la carte : "+carte);
		return carte;
	}
	
	public Coup choisirCoup(Set<Joueur> participants) {
		if(coupsPossibles(participants)) { //pourquoi ca renvoie un coup comment on sairt ca???
			
		}
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);		
	}
	
	public void deposer(Borne borne) {
		zoneDeJeu.deposer(borne);
	}

	public void deposer(Limite limite) {
		zoneDeJeu.deposer(limite);
	}

	public void deposer(Bataille bataille) {
		zoneDeJeu.deposer(bataille);
	}

	public void deposer(Botte botte) {
		zoneDeJeu.deposer(botte);
	}
	
	public int donnerLimitationVitesse() {
		return zoneDeJeu.donnerLimitationVitesse();
	}
	
	public boolean estBloque() {
		return zoneDeJeu.estBloque();
	}
	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}

	public Set<Coup> coupsPossibles(Set<Joueur> participants) {
		Set<Coup> coups = new HashSet<>();
		for (Joueur participant : participants) {
			for (Carte carte : main) {
				Coup coup = new Coup(carte, participant);
				if (coup.estValide(this)) {
					coups.add(coup);
				}
			}
		}
		return coups;
	}

	public Set<Coup> coupsDefausse() {
		Set<Coup> coups = new HashSet<>();
		for (Carte carte : main) {
			Coup coup = new Coup(carte, null);
			coups.add(coup);
		}
		return coups;
	}

	public boolean deposer(Carte c) {
		return zoneDeJeu.deposer(c);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur) {
			Joueur joueur = (Joueur) obj;
			return nom.equals(joueur.getNom());
		}
		return false;
	}
}
