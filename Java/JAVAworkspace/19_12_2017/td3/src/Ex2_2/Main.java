package Ex2_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Etudiant e1 = new Etudiant("Dupont1", 21);
		Etudiant e2 = new Etudiant("Bloom", 36);
		Etudiant e3 = new Etudiant("Dupont2", 15);
		
		ArrayList<Etudiant> list = new ArrayList<>();
		
		list.add(e1);
		list.add(e2);
		list.add(e3);

		System.out.println(list);
		Collections.sort(list, new Etudiant());
		System.out.println(list);
	}
}

class Etudiant implements Comparator<Etudiant>{
	String nom;
	int age;
	ArrayList<Etudiant> list;

	public Etudiant() {
		this.nom = "AIT TIRITE";
		this.age = 3;
	}
	
	public Etudiant(String nom, int age) {
		this.nom = nom;
		this.age = age;
		this.list = new ArrayList<Etudiant>();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.toString().equals(this.toString())){
			return true;
		}
		return false;
	}
	
	@Override
	protected Etudiant clone() {
		return new Etudiant(this.nom, this.age);
	}

	@Override
	public String toString() {
		return "nom : "+this.nom+" age : "+this.age;
	}

//	@Override
//	public int compareTo(Etudiant arg0) {
////		if(arg0.age<this.age){
////			return 1;
////		}
//		if(arg0.nom.compareToIgnoreCase(this.nom)<0){
//			return 1;
//		}
//		return -1;
//	}

	@Override
	public int compare(Etudiant arg0, Etudiant arg1) {
		if(arg0.age<this.age){
			return 1;
		}
		if(arg0.nom.compareToIgnoreCase(this.nom)<0){
			return -1;
		}
		return 0;
	}
}