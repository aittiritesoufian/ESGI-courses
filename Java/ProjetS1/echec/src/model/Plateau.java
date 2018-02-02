package model;

import java.util.HashMap;

public class Plateau {

	protected HashMap<Case, Pieces> cases;

	public Plateau(HashMap<Case, Pieces> cases) {
		super();
		this.cases = cases;
	}

	public HashMap<Case, Pieces> getCases() {
		return cases;
	}

	public void setCases(HashMap<Case, Pieces> cases) {
		this.cases = cases;
	}

}
