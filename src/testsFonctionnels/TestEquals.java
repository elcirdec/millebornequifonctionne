package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Probleme.Type;

public class TestEquals {

	public static void main(String[] args) {
		Attaque att = new Attaque(1, Type.ACCIDENT);
		Attaque att2 = new Attaque(1, Type.ACCIDENT);
		Attaque att3 = new Attaque(1, Type.CREVAISON);
		Borne borne = new Borne(1, 50);
		Borne borne2 = new Borne(1, 50);
		Borne borne3 = new Borne(1, 100);
		Parade par = new Parade(1, Type.ACCIDENT);
		Parade par2 = new Parade(1, Type.ACCIDENT);
		Parade par3 = new Parade(1, Type.CREVAISON);
		DebutLimite lim = new DebutLimite(1);
		DebutLimite lim2 = new DebutLimite(1);
		FinLimite lim3 = new FinLimite(1);

		System.out.println(att.equals(att2));
		System.out.println(att.equals(att3));
		System.out.println(att.equals(borne));
		System.out.println(borne.equals(borne2));
		System.out.println(borne.equals(borne3));
		System.out.println(borne.equals(par));
		System.out.println(par.equals(par2));
		System.out.println(par.equals(par3));
		System.out.println(par.equals(lim));
		System.out.println(lim.equals(lim2));
		System.out.println(lim.equals(lim3));

	}

}