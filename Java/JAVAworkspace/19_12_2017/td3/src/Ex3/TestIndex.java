package Ex3;

public class TestIndex {
	public static void main(String args[]) {
		Index monIndex = new Index();
		monIndex.ajouter("Java", 25);
		monIndex.ajouter("C++", 45);
		monIndex.ajouter("Java", 12);
		monIndex.ajouter("objet", 15);
		monIndex.ajouter("polymorphisme", 45);
		monIndex.ajouter("Java", 25);
		monIndex.liste();
	}
}
