package cartes;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {

		String nom = "";

		switch(getType()) {

		case CREVAISON:
			nom = "Crevaison";
			break;
		case ESSENCE:
			nom = " Panne d'essence";
			break;

		case ACCIDENT:
			nom = "Accident";
			break;

		case FEU:
			nom = " Feu rouge";
			break;

		}
		return nom;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (getClass() == obj.getClass() && obj != null) {
			Attaque atq = (Attaque) obj;
			return type.equals(atq.getType());
		}
		return false;

	}


}
