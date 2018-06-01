
public class Arbre {

	private Integer racine;
	private Arbre droit;
	private Arbre gauche;
	private Arbre parent;

	public Arbre(Integer racine, Arbre gauche, Arbre droit, Arbre parent) {
		super();
		this.racine = racine;
		this.droit = droit;
		this.gauche = gauche;
		this.parent = parent;
	}

	public Arbre() {
		super();
		this.racine = null;
		this.droit = null;
		this.gauche = null;
	}

	public Arbre(Integer racine) {
		super();
		this.racine = racine;
		this.droit = null;
		this.gauche = null;
		this.parent = null;
	}

	public Arbre getParent() {
		return parent;
	}

	public void setParent(Arbre parent) {
		this.parent = parent;
	}

	public Integer getRacine() {
		return racine;
	}

	public void setRacine(Integer racine) {
		this.racine = racine;
	}

	public Arbre getDroit() {
		return droit;
	}

	public void setDroit(Arbre droit) {
		droit.setParent(this);
		this.droit = droit;
	}

	public Arbre getGauche() {
		return gauche;
	}

	public void setGauche(Arbre gauche) {
		gauche.setParent(this);
		this.gauche = gauche;
	}

	public boolean estVide() {// OK
		if (this.droit == null && this.gauche == null)
			return true;
		return false;
	}

	public String prefix() {// OK
		String value = String.valueOf(this.racine) + " ";
//		if(this.getParent() != null) {
//			value += "parent : " +this.getParent().getRacine()+ " / ";
//		}
		if (this.gauche != null)
			value += gauche.prefix();
		if (this.droit != null)
			value += droit.prefix();
		return value;
	}

	public Arbre rotationGauche() { // OK
		if (this.droit != null) {
			Arbre d = this.droit;
			Arbre p = this.parent;
			this.droit = d.getGauche();
			if(this.getParent().getDroit() != null && this.getParent().getDroit().getRacine() == this.racine) {
				this.getParent().setDroit(d);
//				System.out.println("first------------------");
			}
			if(this.getParent().getGauche() != null && this.getParent().getGauche().getRacine() == this.racine) {
				this.getParent().setGauche(d);
//				System.out.println("second------------------");
			}
			d.setGauche(this);
		}
		return this;
	}

	public Arbre rotationDroite() { // OK
		if (this.gauche != null) {
			Arbre g = this.gauche;
			Arbre p = this.parent;
			this.gauche = g.getDroit();
			if(this.getParent().getDroit() != null && this.getParent().getDroit().getRacine() == this.racine) {
				this.getParent().setDroit(g);
			} else {
				this.getParent().setGauche(g);
			}
			g.setDroit(this);
		}
		return this;
	}

	public int taille() {// OK
		int taille = 1;
		if (this.gauche != null)
			taille += gauche.taille();
		if (this.droit != null)
			taille += droit.taille();
		return taille;
	}

	public int hauteur() { // OK
		int hauteur = 0;
		int hauteurD = 0;
		int hauteurG = 0;
		
		if (this.droit != null || this.gauche != null)
			hauteur += 1;
		if (this.gauche != null)
			hauteurG += this.gauche.hauteur();
		if (this.droit != null)
			hauteurD += this.droit.hauteur();
		
		hauteur += (hauteurD > hauteurG) ? hauteurD : hauteurG;
		
		return hauteur;
	}

	public boolean estEquilibre() {// OK
		Integer hdroit = -1;
		Integer hgauche = -1;

		if (this.droit != null)
			hdroit = this.droit.hauteur();
		if (this.gauche != null)
			hgauche = this.gauche.hauteur();

		Integer val = hdroit - hgauche;

		if (1 >= val && val >= -1) {
			if (this.droit != null && !this.droit.estEquilibre())
				return false;
			if (this.gauche != null && !this.gauche.estEquilibre())
				return false;
			return true;
		}
		return false;
	}
}
