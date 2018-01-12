package Ex3;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Index {

	private TreeMap<String, TreeSet<Integer>> index;

	public Index() {
		index = new TreeMap<String, TreeSet<Integer>>();
	}

	public void ajouter(String nom, Integer numero) {
		TreeSet<Integer> numeros = this.index.get(nom);
		if (numeros != null) {
			numeros.add(numero);
			this.index.put(nom, numeros);
		} else {
			numeros = new TreeSet<Integer>();
			numeros.add(numero);
			this.index.put(nom, numeros);
		}
	}

	public void liste(){
		Set<Map.Entry<String, TreeSet<Integer>>> entrees = this.index.entrySet();
		Iterator iter = entrees.iterator();
		while(iter.hasNext()){
			Map.Entry<String, TreeSet<Integer>> entree = (Map.Entry) iter.next();
			String cle = entree.getKey();
			TreeSet<Integer> value = entree.getValue();
			System.out.println(cle+" : "+value);
		}
	}
}
