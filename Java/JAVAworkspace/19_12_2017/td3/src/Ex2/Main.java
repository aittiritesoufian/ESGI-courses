package Ex2;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Etudiant e1 = new Etudiant("Dupont", 20);
		Etudiant e2 = new Etudiant("Dupont", 20);
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
	}
}

class Etudiant implements Comparable<Etudiant>{
	
	String nom;
	int age;
	ArrayList<Etudiant> list;
	
	public Etudiant(String nom, int age) {
		this.nom = nom;
		this.age = age;
		this.list = new ArrayList<Etudiant>();
	}
	
	public boolean equals(Etudiant obj) {
		if(obj.toString().equals(this.toString())){
			return true;
		}
		return false;
	}
	
	@Override
	protected Etudiant clone() {
		try {
			return (Etudiant) super.clone();
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public String toString() {
		return "nom : "+this.nom+" age : "+this.age;
	}

	@Override
	public int compareTo(Etudiant o) {
		// TODO Auto-generated method stub
		return 0;
	}
}