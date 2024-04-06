package testsFonctionnels;

import cartes.*;

public class TestJeuDeCartesClass {

	public static void main(String[] args) {

		JeuDeCartes jdc = new JeuDeCartes();
		System.out.println(jdc.getListeCartes());
		System.out.println(jdc.checkCount());

	}

}