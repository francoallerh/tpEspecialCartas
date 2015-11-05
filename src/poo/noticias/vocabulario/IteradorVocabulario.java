package poo.noticias.vocabulario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class IteradorVocabulario implements Iterator<String>{

	ArrayList<Map.Entry<String, Integer>> elementos;
	int posActual = 0;
	
	public IteradorVocabulario(Set<Map.Entry<String, Integer>> vocabulario, Comparator<Map.Entry<String, Integer>> c) {
		this.elementos = new ArrayList<Map.Entry<String,Integer>>();
		elementos.addAll(vocabulario);
		Collections.sort(this.elementos, c);
		
	}
	@Override
	public boolean hasNext() {
		return posActual < elementos.size();
	}

	@Override
	public String next() {
		if (hasNext())
			return elementos.get(posActual++).getKey();

		throw new NoSuchElementException();
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
