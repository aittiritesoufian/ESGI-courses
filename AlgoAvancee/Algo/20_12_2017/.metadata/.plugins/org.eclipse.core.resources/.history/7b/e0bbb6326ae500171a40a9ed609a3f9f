package td;

public class Exercice5 {

	public static void main(String[] args) {
		Long startTime = System.currentTimeMillis();
		
		Integer[] tab = new Integer[10000];
		
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int)(Math.random()*100);
			System.out.println(tab[i]);
		}

		System.out.println("--------TRIS-----------");
		//afficher un tableau "trie à bulle"
		int temp = 0;
		for (int i = tab.length-1; i > 0; i--) {
			for (int bulle = 0; bulle < i; bulle++) {
					if(tab[bulle+1] > tab[bulle]){
						continue;
					} else {
						temp = tab[bulle+1];
						tab[bulle+1] = tab[bulle];
						tab[bulle] = temp;
					}
			}
		}
		

		System.out.println("--------RESULTAT-----------");
		for (int a = 0; a < tab.length; a++) {
			System.out.println(tab[a]);
		}

		Long stopTime = System.currentTimeMillis();
		System.out.println("Running on : "+(double)(stopTime-startTime)/1000+" sec.");
	}

}
