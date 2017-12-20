package Ex1;

import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		Etudiant e1 = new Etudiant("Dupont1", 21);
		Etudiant e2 = new Etudiant("Dupont2", 20);
		Etudiant e3 = new Etudiant("Bloom", 20);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e1 == e2);
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		
		Etudiant e4 = e1.clone();
		System.out.println(e4);
		System.out.println(e1.equals(e4));
		
		HashSet<Etudiant> set = new HashSet<Etudiant>();
		System.out.println(set);
		set.add(e1);
		set.add(e2);
		set.add(e3);
		System.out.println(set.contains(e4));
		System.out.println(set);
		set.add(e4);
		System.out.println(set);
	}
}

class Etudiant implements Cloneable{
	
	String nom;
	int age;
	
	public Etudiant(String nom, int age) {
		this.nom = nom;
		this.age = age;
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
}