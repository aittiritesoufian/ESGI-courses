package exo3;

public class PointNom extends Point {

	private char nom;

	public PointNom(char nom, int x, int y) {
		super(x,y);
		this.nom = nom;
	}
	
	public void affCoordNom(){
		System.out.println("Nom : "+this.nom);
		this.afficheCoord();
	}

}
