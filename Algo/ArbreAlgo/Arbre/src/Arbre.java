
public class Arbre {

	private Integer racine;
	private Arbre droit;
	private Arbre gauche;

	public Arbre(Integer racine, Arbre gauche, Arbre droit) {
		super();
		this.racine = racine;
		this.droit = droit;
		this.gauche = gauche;
	}

	public Arbre(Integer racine) {
		super();
		this.racine = racine;
		this.droit = null;
		this.gauche = null;
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
		this.droit = droit;
	}

	public Arbre getGauche() {
		return gauche;
	}

	public void setGauche(Arbre gauche) {
		this.gauche = gauche;
	}
	
	public boolean estVide() {// OK
		if(this.droit == null && this.gauche == null)
			return true;
		return false;
	}
	
	public String prefix() {//OK
		String value = String.valueOf(this.racine)+" ";
		if(this.gauche != null)
			value += gauche.prefix();
		if(this.droit != null)
			value += droit.prefix();
		return value;
	}
	
	public Arbre rotationGauche() { //OK
		Arbre d = this.droit;
		this.droit = d.getGauche();
		d.setGauche(this);
		return this;
	}
	
	public Arbre rotationDroite() { //OK
		Arbre g = this.gauche;
		this.gauche = g.getDroit();
		g.setDroit(this);
		return this;
	}
	
	public int taille() {//OK
		int taille = 1;
		if(this.gauche != null)
			taille += gauche.taille();
		if(this.droit != null)
			taille += droit.taille();
		return taille;
	}

	public int hauteur() { //OK
		int hauteur = 0;
		if(this.droit != null || this.gauche != null)
			hauteur += 1;
		if(this.gauche != null)
			hauteur += this.gauche.hauteur();
		if(this.droit != null)
			hauteur += this.droit.hauteur();
		return hauteur;
	}
	
	public boolean estEquilibre() {//OK
		Integer hdroit = -1;
		Integer hgauche = -1;
		
		if(this.droit !=null )
			hdroit = this.droit.hauteur();
		if(this.gauche != null)
			hgauche = this.gauche.hauteur();
		
		Integer val = hdroit - hgauche;
		
		if(1 >= val && val >= -1) {
			if(this.droit != null && !this.droit.estEquilibre())
				return false;
			if(this.gauche != null && !this.gauche.estEquilibre())
				return false;
			return true;
		}
		return false;
	}
}
