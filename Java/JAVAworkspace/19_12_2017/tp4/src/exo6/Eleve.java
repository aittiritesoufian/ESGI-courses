package exo6;

public class Eleve {
	String nom;
	int noteAlgo;
	int notejava;

	public Eleve(String nom, int noteAlgo, int notejava) {
		this.nom = nom;
		this.noteAlgo = noteAlgo;
		this.notejava = notejava;
	}

	public static void main(String[] args) {
		MonArrLst maliste = new MonArrLst();
		Eleve e1 = new Eleve("Titi", 12, 16);
		maliste.add(e1);
		Eleve e2 = new Eleve("Toto", 7, 3);
		maliste.add(e2);
		Eleve e3 = new Eleve("Tata", 4, 8);
		maliste.add(e3);
		System.out.println(maliste);
	}

	public String toString() {
		return nom;
	}
}
