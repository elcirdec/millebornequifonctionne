package cartes;

import java.util.Objects;

public class Borne extends Carte {

	private int km;
	
	public Borne(int km, int nombre) {
		super(nombre);
		this.km=km;
	}
	
	public int getKm() {
		return km;
	}

	@Override
	public String toString() {
		return "Borne [km=" + km + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(km);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne) {
			Borne borne = (Borne) obj;
			return km == borne.km;
		}
		return false;
	}
	
	
	
	
}
