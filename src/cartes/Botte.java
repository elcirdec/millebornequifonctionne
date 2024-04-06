package cartes;

public class Botte extends Probleme {

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {

		String nom = "";

		switch(getType()) {

		case CREVAISON:
			nom = "Increvable";
			break;
		case ESSENCE:
			nom = " Citerne d'essence";
			break;

		case ACCIDENT:
			nom = "As du volant";
			break;
			
		case FEU:
			nom = " Vehicule prioritaire";
			break;

		}
		return nom;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (getClass() == obj.getClass() && obj != null) {
			Botte botte = (Botte) obj;
			return type.equals(botte.getType());
		}
		return false;

	}

}
