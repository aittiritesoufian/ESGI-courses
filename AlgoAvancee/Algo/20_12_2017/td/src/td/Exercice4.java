package td;

public class Exercice4 {

	public static void main(String[] args) {
		Long startTime = System.currentTimeMillis();
		
		Integer[] tab = new Integer[100];
		
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
			for (int j = i+1; i < tab.length; i++) {
				if(min > tab[j]){
					position = j;
				}
			}
			temp = tab[i];
			tab[i] = tab[position];
			tab[position] = temp;
		}

		System.out.println("--------RESULTAT-----------");
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}

		Long stopTime = System.currentTimeMillis();
		System.out.println("Running on : "+(double)(stopTime-startTime)/1000+" sec.");
	}

}
