package td;

public class Exercice4 {

	public static void main(String[] args) {
		Long startTime = System.currentTimeMillis();
		
		Integer[] tab = new Integer[10];
		
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int)(Math.random()*100);
			System.out.println(tab[i]);
		}

		System.out.println("--------TRIS-----------");
		//afficher un tableau "tris sélection"
		int temp = 0;
		int min = 0;
		int position = 0;
		for (int i = 0; i < tab.length; i++) {
			min = tab[i];
			position = i;
			for (int j = i+1; j < tab.length; j++) {
				if(min > tab[j]){
					min = tab[j];
					position = j;
				}
			}
			temp = tab[i];
			tab[i] = tab[position];
			tab[position] = temp;
		}

		System.out.println("--------RESULTAT-----------");
		for (int a = 0; a < tab.length; a++) {
			System.out.println(tab[a]);
		}

		Long stopTime = System.currentTimeMillis();
		System.out.println("Running on : "+(double)(stopTime-startTime)/1000+" sec.");
	}

}