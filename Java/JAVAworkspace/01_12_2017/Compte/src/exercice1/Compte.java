package exercice1;

public class Compte {

	private String nom;
	private int numCompte;
	private int solde;
	private int decouvertMax;
	private int debitMax;
	private String releveComtpe;
	private String cacheReleve;
	private static int nbComptes = 0;

	public Compte(String nom) {
		super();
		this.nom = nom;
		this.numCompte = Compte.nbComptes;
		this.solde = 0;
		this.decouvertMax = 800;
		this.debitMax = 1000;
		this.releveComtpe = "";
		Compte.nbComptes++;
	}

	public Compte(String nom, int solde, int montantDecouvertMax, int montantDebitMax) {
		super();
		this.nom = nom;
		this.numCompte = Compte.nbComptes;
		this.solde = solde;
		this.decouvertMax = montantDecouvertMax;
		this.debitMax = montantDebitMax;
		this.releveComtpe = "";
		Compte.nbComptes++;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public int getDecouvertMax() {
		return decouvertMax;
	}

	public void setDecouvertMax(int decouvertMax) {
		this.decouvertMax = decouvertMax;
	}

	public int getDebitMax() {
		return debitMax;
	}

	public void setDebitMax(int debitMax) {
		this.debitMax = debitMax;
	}

	public String getReleveComtpe() {
		return releveComtpe;
	}

	public void setReleveComtpe(String releveComtpe) {
		this.releveComtpe = releveComtpe;
	}

	public String getCacheReleve() {
		return cacheReleve;
	}

	public void setCacheReleve(String cacheReleve) {
		this.cacheReleve = cacheReleve;
	}

	public String toString() {
		return "Compte [nom=" + nom + ", numCompte=" + numCompte + ", solde=" + solde + ", montantDecouvertMax="
				+ decouvertMax + ", montantDebitMax=" + debitMax + "] " + this.isDecouvert();
	}

	public String isDecouvert() {
		if (this.getSolde() < 0) {
			return "Le compte est à découvert de " + this.solde;
		}
		return "";
	}

	public void crediter(int val, boolean virement) {
		if (val > 0) {
			this.setSolde(this.getSolde() + val);
			if(!virement){
				this.setCacheReleve("Crédit de "+val);
				this.updateReleveCompte();
			}
		}
	}

	public boolean debiter(int val, boolean virement) {
		if (val > 0) {
			if ((int)(0-this.getDecouvertMax()) <= (this.getSolde() - val)) {
				if (val <= this.getDebitMax()) {
					this.setSolde(this.getSolde()-val);
					if(!virement){
						this.setCacheReleve("Débit de "+val);
						this.updateReleveCompte();
					}
					return true;
				}
			}
		}
		return false;
	}

	public boolean virementVers(int somme, Compte c) {
		if (this.debiter(somme,true)) {
			c.crediter(somme,true);
			this.setCacheReleve("Virement sortant de "+somme);
			this.updateReleveCompte();
			c.setCacheReleve("Virement entrant de "+somme);
			c.updateReleveCompte();
			return true;
		}
		return false;
	}
	
	public void updateReleveCompte(){
		this.setReleveComtpe(this.getReleveComtpe()+this.getCacheReleve()+"\n");
		this.setCacheReleve(null);
	}

}
