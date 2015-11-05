package poo.noticias.vocabulario;

import java.util.ArrayList;
import java.util.Iterator;

public class VocabularioTest {
	
	public static void main(String[] args) {
		Vocabulario vocabulario = new Vocabulario();

		for (int i = 0 ; i<args.length;i++)
			vocabulario.actualizar(args[i]);
		
		//vocabulario.actualizar("una clase define un molde para la creación de objetos");
		//vocabulario.actualizar("los objetos encapsulan estado y comportamiento");
		//vocabulario.actualizar("diseñe una solución orientada a objetos para modelar el siguiente comportamiento");
		
		System.out.println("Vocabulario:");
		System.out.println(vocabulario);
		
		System.out.println("\nVocabulario en orden alfabetico: ");
		Iterator<String> alfabetico = vocabulario.iteradorAlfabetico(false);
		while (alfabetico.hasNext()){
			System.out.println(alfabetico.next());
		}

		System.out.println("\nVocabulario en orden alfabetico inverso: ");
		Iterator<String> alfabeticoInverso = vocabulario.iteradorAlfabetico(true);
		while (alfabeticoInverso.hasNext()){
			System.out.println(alfabeticoInverso.next());
		}
		
		System.out.println("\nLas dos palabras más frecuentes son: ");
		ArrayList<String> masFrecuentes = vocabulario.masFrecuentes(2);
		for (String palabra:masFrecuentes)
			System.out.println(palabra+" ("+vocabulario.frecuencia(palabra)+")");
	}

}
