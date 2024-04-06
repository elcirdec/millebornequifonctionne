package cartes;

public class Parade extends Bataille {

	public Parade(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {

		String nom = "";

		switch(getType()) {

		case CREVAISON:
			nom = "Roue de secours";
			break;
		case ESSENCE:
			nom = " Essence";
			break;

		case ACCIDENT:
			nom = "Reparations";
			break;
			
		case FEU:
			nom = " Feu vert";
			break;

		}
		return nom;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (getClass() == obj.getClass() && obj != null) {
			Parade par = (Parade) obj;
			return type.equals(par.getType());
		}
		return false;

	}
}
