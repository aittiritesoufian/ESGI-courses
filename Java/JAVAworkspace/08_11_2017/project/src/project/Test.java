package project;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		/*System.out.println("tapez un mot");
		//Saisie clavier :
		Scanner entree = new Scanner(System.in);
		String mot = entree.nextLine(); //dans mot est stocké une ligne entière
		//Affichage console :
		System.out.println(mot);*/
		
		//exercice 2
		//System.out.println(transform((float)10.2536658574, 2));
		
		//exercice 3
		/*System.out.println(monteCarlo(25));
		System.out.println((Math.PI/4));*/
		
		//Exercice 4
		/*int[] p1 = {1,2,3,4,5,6};
		int[] p2 = {1,2,1,4,5,6};
		System.out.println(rechDoub(p1));
		System.out.println(rechDoub(p2));*/
		
		//Exercice 5
		//System.out.println(Convertir(5));
		
		//Exercice 6
		Scanner entree = new Scanner(System.in);
		System.out.println("Saisissez la valeur limit de test :");
		int val = entree.nextInt();
		syracuse(val);
	}
	
	public static float transform(float x,int n){
		x = (float)((int)((float)(x * Math.pow(10, n))) / Math.pow(10, n));
		return x;
	}
	
	public static double monteCarlo(int nbPoints){
		double x=0;
		double y=0;
		int disk=0;
		for(int i=0;i<nbPoints;i++){
			x=Math.random();
			y=Math.random();
			if((Math.pow(x, 2)+Math.pow(y, 2))<1){
				disk++;
			}
		}
		return (nbPoints-disk);
	}
	
	public static boolean rechDoub(int a[]){
		for (int i=0;i<a.length;i++){
			for (int j=0;j<a.length;j++){
				if(i!=j){
					if(a[i]==a[j]){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static String Convertir(int n){
		String textReturn = "";
		if(n<11){
			switch (n) {
			case 1:
				textReturn += "un";
				break;
			case 2:
				textReturn += "deux";
				break;
			case 3:
				textReturn += "trois";
				break;
			case 4:
				textReturn += "quatre";
				break;
			case 5:
				textReturn += "cinq";
				break;
			case 6:
				textReturn += "six";
				break;
			case 7:
				textReturn += "sept";
				break;
			case 8:
				textReturn += "huit";
				break;
			case 9:
				textReturn += "neuf";
				break;
			case 10:
				textReturn += "dix";
				break;

			default:
				break;
			}
		}
		
		return textReturn;
	}
	
	public static void syracuse(int limit){
		int val = 0;
		int compt = 0;
		int max = 0;
		for(int i=limit;i>0;i--){
			val = i;
			compt = 0;
			max = 0;
			while(val>1){
				if(val%2 == 0){//pair
					val = (int)(val/2);
				}else{//impair
					val = (int)((val*3)+1);
				}
				if(val > max){
					max = val;
				}
				compt++;
			}
			System.out.println(i+" à nécessité "+compt+" étapes pour atteindre 1, le nombre maximal atteint à été "+max);
		}
	}

}
