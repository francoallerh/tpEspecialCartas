package poo.noticias.vocabulario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Vocabulario {
	private HashMap<String, Integer> palabras;
	
	public Vocabulario(){
		palabras = new HashMap<String, Integer>();
	}
	
	public void actualizar(String texto){
		String[] palabrasTexto = texto.split(" ");
		for (String pal:palabrasTexto)
			this.agregarPalabra(pal);
	}
	
	public void agregarPalabra(String nuevaPal){
		if (palabras.containsKey(nuevaPal)){
			int cantidadPrevia = palabras.get(nuevaPal);
			palabras.put(nuevaPal, cantidadPrevia+1);
		}
		else
			palabras.put(nuevaPal, 1);		
	}
	
	public int frecuencia(String palabra){
		if (palabras.containsKey(palabra))
			return palabras.get(palabra);
		return 0;
	}
	
	public Iterator<String> iteradorAlfabetico(boolean reverse){
		Comparator<Map.Entry<String, Integer>> c = new ComparadorPalabra();
		if (reverse)
			c = c.reversed();
		return new IteradorVocabulario(palabras.entrySet(), c);
	}
	
	public Iterator<String> iteradorFrecuencia(boolean reverse){
		Comparator<Map.Entry<String, Integer>> c = new ComparadorFrecuencia();
		if (reverse)
			c = c.reversed();
		return new IteradorVocabulario(palabras.entrySet(), c);
	}
	
	public ArrayList<String> masFrecuentes(int n){
		ArrayList<String> masFrec = new ArrayList<String>();
		Iterator<String> ordenadas = iteradorFrecuencia(true);
		int i = 0;
		while (ordenadas.hasNext() && i < n){
			masFrec.add(ordenadas.next());
			i++;
		}
		return masFrec;
	}
	
	@Override
	public String toString(){
		return palabras.toString();
	}

}
