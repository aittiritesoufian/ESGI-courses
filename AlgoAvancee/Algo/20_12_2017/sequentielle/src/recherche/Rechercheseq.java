package recherche;

public class Rechercheseq {

	public static void main(String[] args) {
		Integer[] a = { 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

		System.out.println(isHere(19,a));
	}

	public static boolean isHere(int a, Integer[] b) {
		int iter = 0;
		for (int i = 0; i < b.length; i++) {
			if(b[i]==a){
				return true;
			} else if (b[i]>a){
				break;
			}
			iter++;
		}
		System.out.println("Nombre d'itérations :"+iter);
		return false;
	}

}
