package project;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.println("tapez un mot");
		//Saisie clavier :
		Scanner entree = new Scanner(System.in);
		String mot = entree.nextLine(); //dans mot est stocké une ligne entière
		//Affichage console :
		System.out.println(mot);
	}

}
