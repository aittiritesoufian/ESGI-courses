package exo1;

public class exercice1 {

	public static void main(String[] args) {
		//question 1
		Point unpoint = new Point();
		unpoint.initialise(7, 6);
		
		PointA apoint = new PointA();
		apoint.initialise(8, 9);
		
		apoint.affiche();
		
		//question 2
		/*la Classe PointA ne les possèderais pas non plus et les variables
		x et y ne seraient pas modifiable depuis un objet PointA car elles sont en private.*/
	}

}
