package exercice1;

public class Test {

	public static void main(String[] args) {
		//question 1
		Compte c1 = new Compte("DUPONT");
		c1.setSolde(1000);
		
		//question 2
		Compte c2 = new Compte("DURAND", 50000, 5000, 6000);
		
		System.out.println(c1);
		System.out.println(c2);
		
		//question 3
		c1.debiter(900,false);
		c1.debiter(400,false);
		//question 4
		c2.debiter(600,false);
		//question 5
		c1.crediter(500,false);
		//question 6
		System.out.println(c1);
		System.out.println(c2);
		
		//question 7
		c2.virementVers(1000, c1);
		
		//question 8
		c2.setDebitMax(8000);
		
		//question 9
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println(c1.getReleveComtpe());
		System.out.println("-------");
		System.out.println(c2.getReleveComtpe());
	}

}
