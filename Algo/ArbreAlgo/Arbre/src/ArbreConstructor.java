
public class ArbreConstructor {

	public static void main(String[] args) {
		Arbre a13 = new Arbre(13);
		Arbre a100 = new Arbre(100);
		Arbre a56 = new Arbre(56, a13, a100);
		
		Arbre a121 = new Arbre(121);
		Arbre a107 = new Arbre(107, a56, a121);
		System.out.println(a107.prefix());
		System.out.println(a107.estEquilibre());
		System.out.println(a121.prefix());
		
		a107 = a107.rotationGauche();
		
		System.out.println(a107.prefix());
		System.out.println(a121.prefix());
		
		System.out.println(a121.estEquilibre());
Arbre test=new Arbre();
System.out.println(test.rotationGauche().prefix());
	}

}
