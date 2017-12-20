package td;

public class Exercice6 {

	public static void main(String[] args) {
		Integer[] tab1 = new Integer[100];
		
		for (int i = 0; i < tab1.length; i++) {
			tab1[i] = (int)(Math.random()*100);
		}
		
		Integer[] tab2 = new Integer[1000];
		
		for (int i = 0; i < tab2.length; i++) {
			tab2[i] = (int)(Math.random()*100);
		}
		
		Integer[] tab3 = new Integer[10000];
		
		for (int i = 0; i < tab3.length; i++) {
			tab3[i] = (int)(Math.random()*100);
		}
		
		double tab1Select100 = selection(tab1);
		double tab1Select1000 = selection(tab2);
		double tab1Select10000 = selection(tab3);
		
		double tab1Bulle100 = bulle(tab1);
		double tab1Bulle1000 = bulle(tab2);
		double tab1Bulle10000 = bulle(tab3);
		
		System.out.println("              |          |          |          |");
		System.out.println("              |    100   |   1000   |  10 000  |");
		System.out.println("______________|__________|__________|__________|");
		System.out.println("Tri selection |___"+tab1Select100+"__|___"+tab1Select1000+"__|___"+tab1Select10000+"__|");
		System.out.println("Tri bulles    |___"+tab1Bulle100+"__|___"+tab1Bulle1000+"__|___"+tab1Bulle10000+"__|");
		
	}
	
	public static double selection(Integer[] tab){
		Long startTime = System.currentTimeMillis();
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
		Long stopTime = System.currentTimeMillis();
		return (double)(stopTime-startTime)/1000;
	}
	
	public static double bulle(Integer[] tab){
		Long startTime = System.currentTimeMillis();
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
		Long stopTime = System.currentTimeMillis();
		return (double)(stopTime-startTime)/1000;
	}

}
