package exo6;

import java.util.ArrayList;

public class MonArrLst extends ArrayList<Eleve> {
	
	@Override
	public String toString() {
		String val = "";
		int compt = 1;
		for (Eleve eleve : this) {
			val += compt+" : "+eleve.nom+"\n";
			compt++;
		}
		return val;
	}
}
