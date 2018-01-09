package exo4;

public class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void affiche() {
		System.out.println("Coordonnées : " + x + " " + y);
	}
}
