package recherche;

public class Rechercheseq {

	public static void main(String[] args) {
		
		Integer[] a = {15,25,30,65,85,96};
		
		//System.out.println(isHere(35,a));
		System.out.println(dicho(a, 0, a.length-1, 53));
	}

	public static boolean isHere(int a, Integer[] b) {
		int iter = 0;
		for (int i = 0; i < b.length; i++) {
			iter++;
			if(b[i]==a){
				System.out.println("Nombre d'itérations :"+iter);
				return true;
			} else if (b[i]>a){
				break;
			}
		}
		System.out.println("Nombre d'itérations :"+iter);
		return false;
	}
	
	public static boolean dicho(Integer[] tab, int indD, int indF, int val){
		int pivot = Math.round((indD+indF)/2);
		System.out.println(pivot);
		if(indF-indD==1){
			return false;
		}
		if(tab[pivot]>val){
			return dicho(tab,indD,pivot,val);
		}else if(tab[pivot]<val){
			return dicho(tab,pivot,indF,val);
		}
		return true;
	}

}
