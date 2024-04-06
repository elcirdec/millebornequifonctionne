package testsFonctionnels;

import java.util.List;
import cartes.*;
import cartes.Probleme.Type;
import jeu.*;


public class TestZoneDeJeu implements Cartes{
	public static void main(String[] args) {
		
		ZoneDeJeu zdj = new ZoneDeJeu();
		Attaque accident = new Attaque(1, Type.ACCIDENT);
		Attaque panneEssence = new Attaque(1, Type.ESSENCE);
		Parade essence = new Parade(1, Type.ESSENCE);
		Botte asDuVolant = new Botte(1, Type.ACCIDENT);
		
		zdj.deposer(FEU_ROUGE);
		System.out.println(zdj.estBloque());
		zdj.deposer(PRIORITAIRE); 
		System.out.println(zdj.estBloque());
		zdj.deposer(accident);
		System.out.println(zdj.estBloque());
		zdj.deposer(asDuVolant);
		System.out.println(zdj.estBloque());
		zdj.deposer(panneEssence);
		System.out.println(zdj.estBloque());
		zdj.deposer(essence);		
		System.out.println(zdj.estBloque());
		
		//suppression
		System.out.println(zdj.estBloque());
		zdj.deposer(FEU_VERT);		
		System.out.println(zdj.estBloque());
				

	}

}
