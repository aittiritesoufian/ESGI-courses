
public class ArbreConstructor2 {

	public static void main(String[] args) {
		
		Arbre a600 = new Arbre(600);
		Arbre a500 = new Arbre(500);
		Arbre a100 = new Arbre(100);
		Arbre a300 = new Arbre(300);
		Arbre a200 = new Arbre(200);
		Arbre a400 = new Arbre(400);
		Arbre a900 = new Arbre(900);
		Arbre a700 = new Arbre(700);
		Arbre a800 = new Arbre(800);
		Arbre a750 = new Arbre(750);
		Arbre a740 = new Arbre(740);
		Arbre a850 = new Arbre(850);
		Arbre a950 = new Arbre(950);
		
		a600.setDroit(a900);
		a600.setGauche(a500);
		
		a500.setGauche(a100);
		
		a100.setDroit(a300);
		
		a300.setDroit(a400);
		a300.setGauche(a200);
		
		a900.setDroit(a950);
		a900.setGauche(a700);
		
		a700.setGauche(a800);
		
		a800.setDroit(a850);
		a800.setGauche(a750);
		
		a750.setGauche(a740);
		
		// rotations.............
		
		System.out.println(a600.estEquilibre());
		System.out.println(a600.prefix());

		a100.rotationGauche();
		System.out.println(a600.estEquilibre());
		System.out.println(a600.prefix());
		
		a500.rotationDroite();
		System.out.println(a600.estEquilibre());
		System.out.println(a600.prefix());
		
		a800.rotationDroite();
		System.out.println(a600.estEquilibre());
		System.out.println(a600.prefix());

		a700.rotationGauche();
		System.out.println(a600.estEquilibre());
		System.out.println(a600.prefix());

		a900.rotationDroite();
		System.out.println(a600.estEquilibre());
		System.out.println(a600.prefix());
		
	}

}
