package td;

public class Exercice5 {

	public static void main(String[] args) {
		Integer[] tab = new Integer[10];
		
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int)(Math.random()*100);
			System.out.println(tab[i]);
		}

		System.out.println("--------TRIS-----------");
		//afficher un tableau trié en bulle
		int temp = 0;
		for (int bulle = 0; bulle < tab.length-1; bulle++) {
				if(tab[bulle+1] > tab[bulle]){
					continue;
				} else {
					temp = tab[bulle+1];
					tab[bulle+1] = tab[bulle];
					tab[bulle] = temp;
				}
		}
		

		System.out.println("--------RESULTAT-----------");
		for (int a = 0; a < tab.length; a++) {
			System.out.println(tab[a]);
		}
	}

}
