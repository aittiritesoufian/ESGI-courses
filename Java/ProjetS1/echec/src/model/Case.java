package model;

public class Case {

	protected int positionLa;
	protected int positionLo;
	protected String name;

	public Case(int positionLa, int positionLo, String name) {
		super();
		this.positionLa = positionLa;
		this.positionLo = positionLo;
		this.name = name;
	}

	public int getPositionLa() {
		return positionLa;
	}

	public void setPositionLa(int positionLa) {
		this.positionLa = positionLa;
	}

	public int getPositionLo() {
		return positionLo;
	}

	public void setPositionLo(int positionLo) {
		this.positionLo = positionLo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
