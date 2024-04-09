package jeu;

import java.util.ArrayList;
import java.util.*;

import cartes.*;
import cartes.Probleme.Type;


public class ZoneDeJeu implements Cartes {

	private List<Limite> pileLimite = new ArrayList<>();
	private List<Bataille> pileBataille = new ArrayList<>();
	private List<Borne> collectionBorne = new ArrayList<>();
	private Set<Botte> ensembleBotte = new HashSet<>();


	public List<Limite> getPileLimite() {
		return pileLimite;
	}

	public List<Bataille> getPileBataille() {
		return pileBataille;
	}

	public List<Borne> getCollectionBorne() {
		return collectionBorne;
	}

	public Set<Botte> getEnsembleBotte() {
		return ensembleBotte;
	}

	public void deposer(Borne borne) {
		collectionBorne.add(borne);
	}

	public void deposer(Limite limite) {
		pileLimite.add(limite);
	}

	public void deposer(Bataille bataille) {
		pileBataille.add(bataille);
	}

	public void deposer(Botte botte) {
		ensembleBotte.add(botte);
	}

	public boolean deposer(Carte c) {
		if(estDepotAutorise(c)) {
			if(c instanceof Borne ) {
				Borne b = (Borne) c;
				deposer(b);
			}else if(c instanceof Botte ) {
				Botte b = (Botte) c;
				deposer(b);
				Attaque atq = new Attaque(1, b.getType());
				if(pileBataille.contains(atq)){
					pileBataille.remove(atq);
				}
			}else if(c instanceof DebutLimite ) {
				DebutLimite b = (DebutLimite) c;
				deposer(b);
			}else if(c instanceof FinLimite ) {
				FinLimite b = (FinLimite) c;
				deposer(b);
			}else if(c instanceof Bataille ) {
				Bataille b = (Bataille) c;
				deposer(b);
			}
			return true;
		}else {
			return false;
		}
	}

	public int donnerLimitationVitesse() {
		if(pileLimite.isEmpty() || pileLimite.get((pileLimite.size() - 1)) instanceof FinLimite) {
			return 200;
		}
		for(Botte botte : ensembleBotte) {
			if(botte.getType() == Type.FEU) {
				return 200;
			}
		}
		return 50;
	}

	public boolean estBloque() {
		Bataille sommet;
		boolean isPrioritaire = ensembleBotte.contains(PRIORITAIRE);

		if(pileBataille.isEmpty() && isPrioritaire) { // la pile de bataille est vide et il est prioritaire,
			return false;
		}

		else if(!pileBataille.isEmpty()) {
			sommet = pileBataille.get(pileBataille.size() - 1);
			Botte botteSommet = new Botte(1, sommet.getType());
			if(sommet.equals(FEU_VERT)) { // le sommet est une parade de type FEU
				return false;
			}


			if((isPrioritaire) && ((sommet.equals(FEU_ROUGE)) || sommet instanceof Parade || (sommet instanceof Attaque && ensembleBotte.contains(botteSommet)))) {
				return false;
			}


		}

		return true;
	}

	public int donnerKmParcourus() {
		int nbKm=0;
		for(Borne borne : collectionBorne) {
			nbKm += borne.getKm();
		}
		return nbKm; 
	}

	public boolean estDepotAutorise(Carte c) {
		if (c instanceof Borne) {
			if (!estBloque() && ((Borne) c).getKm()<= donnerLimitationVitesse() && donnerKmParcourus() <= 1000) {
				collectionBorne.add((Borne) c);
				return true;
			}
			return false;
		} else if (c instanceof Botte) {
			ensembleBotte.add((Botte) c);
			return true;
		} else if (c instanceof Limite) {
			if (!ensembleBotte.contains(PRIORITAIRE) && pileLimite.isEmpty()) {
				pileLimite.add((Limite) c);
				return true;
			}
			return false;
		} else if (c instanceof FinLimite) {
			if (!ensembleBotte.contains(PRIORITAIRE) && !pileLimite.isEmpty()) {
				pileLimite.add((Limite) c);
				return true;
			}
			return false;
		} else if (c instanceof Bataille) {
			if (pileBataille.isEmpty()){
				if (ensembleBotte.contains(PRIORITAIRE) || c.equals(FEU_ROUGE)){
					Bataille top = FEU_VERT;
				} else {
					Bataille top = FEU_ROUGE; 
				}
			} 
		}
		else { 
			Bataille top = pileBataille.get(pileBataille.size() - 1); 


			if (top instanceof Attaque && ((Bataille) c) instanceof Parade && !ensembleBotte.contains(new Botte(1, ( (Parade) c).getType() ) ) ) {
				pileBataille.add((Bataille) c);
				return true;
			} else if (top instanceof Parade && !ensembleBotte.contains(c) ) {
				pileBataille.add((Bataille) c);
				return true;
			}else {
				return false;
			}
		}

		return false;
	}

}





