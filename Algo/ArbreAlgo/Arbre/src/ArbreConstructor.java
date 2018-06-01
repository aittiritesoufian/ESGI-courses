
public class ArbreConstructor {

	public static void main(String[] args) {
		
		Arbre a500 = new Arbre(500);
		Arbre a14 = new Arbre(14);
		Arbre a300 = new Arbre(300);
		Arbre a473 = new Arbre(473);
		Arbre a211 = new Arbre(211);
		Arbre a336 = new Arbre(336);
		Arbre a352 = new Arbre(352);
		Arbre a702 = new Arbre(702);
		Arbre a658 = new Arbre(658);
		
		a500.setGauche(a14);
		a500.setDroit(a702);
		
		a702.setGauche(a658);
		
		a14.setDroit(a300);
		
		a300.setGauche(a211);
		a300.setDroit(a473);
		
		a473.setGauche(a336);
		
		a336.setDroit(a352);
		
		// rotations
		
		System.out.println(a500.estEquilibre());
		System.out.println(a500.prefix());

		a336.rotationGauche();
		System.out.println(a500.estEquilibre());
		System.out.println(a500.prefix());
		
		a473.rotationDroite();
		System.out.println(a500.estEquilibre());
		System.out.println(a500.prefix());
		
		a14.rotationGauche();
		System.out.println(a500.estEquilibre());
		System.out.println(a500.prefix());
		
	}

}
