package exo2;

public class PointNom extends Point {
	
	private char nom;

	public void setNom(char nom) {
		this.nom = nom;
	}
	
	public void initialisePointNom(char nom, int x, int y){
		this.setNom(nom);
		this.initialise(x, y);
	}
	
	public void affCoordNom(){
		System.out.println("Nom : "+this.nom);
		this.afficheCoord();
	}
}
