package td;

public class Exercice2 {

	public static void main(String[] args) {
		Integer[] tab = new Integer[10];
		
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int)(Math.random()*100);
			//System.out.println(tab[i]);
		}
		
		//afficher a valeur la plus faible
		int min = tab[0];
		for (int i = 0; i < tab.length; i++) {
			if(min > tab[i]){
				min = tab[i];
			}
		}
		
		System.out.println(min);
	}

}