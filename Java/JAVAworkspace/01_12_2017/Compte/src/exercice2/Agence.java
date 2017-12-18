package exercice2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import exercice1.Compte;

public class Agence {

	private String nomDirecteur;
	private String adresse;
	private ArrayList<Compte> lesComptes;

	public Agence(String nomDirecteur, String adresse, ArrayList<Compte> lesComptes) {
		super();
		this.nomDirecteur = nomDirecteur;
		this.adresse = adresse;
		this.lesComptes = lesComptes;
	}

	public Agence(String nomDirecteur, String adresse) {
		super();
		this.nomDirecteur = nomDirecteur;
		this.adresse = adresse;
		this.lesComptes = new ArrayList<>();
	}

	public String getNomDirecteur() {
		return nomDirecteur;
	}

	public void setNomDirecteur(String nomDirecteur) {
		this.nomDirecteur = nomDirecteur;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Compte> getLesComptes() {
		return lesComptes;
	}

	public void setLesComptes(ArrayList<Compte> lesComptes) {
		this.lesComptes = lesComptes;
	}
	
	public void addCompte(Compte c){
		this.lesComptes.add(c);
	}
	
	public Compte getCompte(String titulaire){
		for (Compte compte : lesComptes) {
			if(compte.getNom().equals(titulaire)){
				return compte;
			}
		}
		return null;
	}
	
	public Compte getCompte(int numCompte){
		for (Compte compte : lesComptes) {
			if(compte.getNumCompte() == numCompte){
				return compte;
			}
		}
		return null;
	}
	
	public void createCompte(String name){
		Compte c = new Compte(name);
		this.addCompte(c);
	}
	
	public void createCompte(String name, int solde, int decouvertMax, int debitMax){
		Compte c = new Compte(name, solde, decouvertMax, debitMax);
		this.addCompte(c);
	}
	
	public boolean retrait(Compte c, int montant){
		return c.debiter(montant, false);
	}
	
	public void depot(Compte c, int montant){
		c.crediter(montant, false);
	}
	
	public boolean virement(Compte origine, int montant, Compte destinataire){
		return origine.virementVers(montant, destinataire);
	}
	
	public String releveOperation(int numCompte){
		Compte c = getCompte(numCompte);
		return c.getReleveComtpe();
	}
	
	public void releveAgence(){
		Collections.sort(lesComptes, new Comparator<Compte>() {

			@Override
			public int compare(Compte o1, Compte o2) {
				
				return o1.getNom().compareTo(o2.getNom());
			}
			
		});
		
		for (Compte compte : lesComptes) {
			System.out.println(compte);
		}
	}

}