package cartes;

import java.util.*;

import utils.Utils;

public class JeuDeCartes {

	Botte asDuVolant= new Botte(1,Probleme.Type.ACCIDENT); 
	Botte increvable= new Botte(1,Probleme.Type.CREVAISON); 
	Botte citerneEssence= new Botte(1,Probleme.Type.ESSENCE); 
	Botte vehiculePrio= new Botte(1,Probleme.Type.FEU);


	DebutLimite debutLimite= new DebutLimite(4);
	Attaque feuRouge= new Attaque(5,Probleme.Type.FEU);
	Attaque panneEssence= new Attaque(3,Probleme.Type.ESSENCE);
	Attaque crevaison= new Attaque(3,Probleme.Type.CREVAISON);
	Attaque accident= new Attaque(3,Probleme.Type.ACCIDENT);

	FinLimite finLimite= new FinLimite(6);
	Parade feuVert= new Parade(14,Probleme.Type.FEU);
	Parade essence= new Parade(6,Probleme.Type.ESSENCE);
	Parade RoueDeSecours= new Parade(6,Probleme.Type.CREVAISON);
	Parade reparation= new Parade(6,Probleme.Type.ACCIDENT);

	Borne borne25= new Borne(25, 10);
	Borne borne50= new Borne(50, 10);
	Borne borne75= new Borne(75, 10);
	Borne borne100= new Borne(100, 12);
	Borne borne200= new Borne(200, 4);

	public JeuDeCartes() {
		for (Carte c : typesDeCarte) {
			for (int i = 0; i < c.getNombre(); i++) {
				listeCartes.add(c);
			}
		}
		listeCartes=Utils.melanger(listeCartes);
	}
	
	private Carte[] typesDeCarte= new Carte[] {asDuVolant,increvable,citerneEssence,
			vehiculePrio,debutLimite,feuRouge,panneEssence,crevaison,accident,
			finLimite,feuVert,essence,RoueDeSecours,reparation,borne25,borne50
			,borne75,borne100,borne200} ; 

	List<Carte> listeCartes = new ArrayList<Carte>();

	public List<Carte> getListeCartes() {
		return listeCartes;
	}
	
	public boolean checkCount() {
		if (listeCartes.size() != 106) {
			return false;
		}
		
		for (Carte c : typesDeCarte) {
			int nb = 0;
			for (int i = 0; i < listeCartes.size(); i++) {
				if (c.equals(listeCartes.get(i))) {
					nb++;
				}
			}
			if (nb != c.getNombre()) {
				return false;
			}
		}
		
		return true;
	}

	public Carte[] getTypeCarte() {
		return typesDeCarte;
	}
	

}
