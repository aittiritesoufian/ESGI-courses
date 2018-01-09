package exo5;

public class Point {
	private double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void deplace(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void affiche() {
		System.out.println("Point de coordonnées : " + x + " " + y);
	}
}
