package td;

public class Exercice3 {

	public static void main(String[] args) {
		Integer[] tab = new Integer[10];
		
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int)(Math.random()*100);
			System.out.println(tab[i]);
		}

		System.out.println("--------TRIS-----------");
		//afficher un tableau trié dans l'ordre
		int temp = 0;
		int min = 0;
		int position = 0;
		for (int i = 0; i < tab.length; i++) {
			min = tab[i];
			position = i;
			System.out.println("position i = "+position);
			for (int j = i+1; j < tab.length; j++) {
				if(min > tab[j]){
					min = tab[j];
					position = j;
				}
				System.out.println("position : "+position+" val = "+tab[position]);
			}
			temp = tab[i];
			tab[i] = tab[position];
			tab[position] = temp;
//			for (int j = i+1; j < tab.length; j++) {
//				if(tab[i] > tab[j]){
//					temp = tab[i];
//					tab[i] = tab[j];
//					tab[j] = temp;
//					temp = 0;
//				}
//			}
		}

		System.out.println("--------RESULTAT-----------");
		for (int a = 0; a < tab.length; a++) {
			System.out.println(tab[a]);
		}
	}

}
