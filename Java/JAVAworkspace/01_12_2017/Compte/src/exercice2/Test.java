package exercice2;

public class Test {

	public static void main(String[] args) {
		Agence a = new Agence("CONDE", "242, Rue du faubourg saint antoine, 75012 PARIS");
		a.createCompte("HARANG");
		a.createCompte("AIT TIRITE", 3000, 500, 200);
		
		//recherche par nom
		System.out.println(a.getCompte("AIT TIRITE"));
		System.out.println(a.getCompte("HARANG"));

		//recherche par id
		System.out.println(a.getCompte(0));
		System.out.println(a.getCompte(1));
		
		//depots & retraits & virements
		a.depot(a.getCompte(1), 250);
		a.retrait(a.getCompte(1), 60);
		a.virement(a.getCompte(1), 60, a.getCompte("HARANG"));

		//recherche par id
		System.out.println(a.getCompte(1));
		System.out.println(a.getCompte(0));
		
		//relevé d'opérations
		System.out.println("----------------Relevé d'opérations-----------------");
		System.out.println(a.releveOperation(a.getCompte("HARANG").getNumCompte()));
		System.out.println("----------------");
		System.out.println(a.releveOperation(a.getCompte("AIT TIRITE").getNumCompte()));
		
		//relevé d'agence
		System.out.println("----------------Relevé d'agence-----------------");
		a.releveAgence();
		
	}

}