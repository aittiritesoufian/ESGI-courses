package td;


public class Exercice {

	public static void main(String[] args) {
		int[] tab = {2,33,5,9,10,4,1,56,7,8};

		int min = tab[0];
		for (int i = 0; i < tab.length; i++) {
			if(min > tab[i]){
				min = tab[i];
			}
		}
		
		System.out.println(min);
	}

}
