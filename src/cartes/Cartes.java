package cartes;

import cartes.Probleme.Type;

public interface Cartes {
	final Botte PRIORITAIRE = new Botte(1, Type.FEU);
    final Attaque FEU_ROUGE = new Attaque(1,Type.FEU);
    final Parade FEU_VERT = new Parade(1,Type.FEU);
}
