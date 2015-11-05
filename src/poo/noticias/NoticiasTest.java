package poo.noticias;

import java.util.ArrayList;

import poo.noticias.filtros.*;

public class NoticiasTest {

	public static void main(String[] args) {
		Categoria todasLasNoticias = new Categoria("menu");
		
		Categoria politica = new Categoria("Pol�tica");
		todasLasNoticias.addMiembro(politica);
		
		Categoria ocio = new Categoria("Ocio");
		todasLasNoticias.addMiembro(ocio);
		
		Categoria viajes = new Categoria("Viajes");
		ocio.addMiembro(viajes);
		
		Noticia n1 = new Noticia("Resultado Elecciones");
		n1.addContenido("Hay balotage en Argentina");
		n1.addContenido("Los resultados de las elecciones indican que hay segunda vuelta");
		politica.addMiembro(n1);
		
		Noticia n2 = new Noticia("Tandil");
		n2.addContenido("Tandil entre los destinos m�s visitados en las vacaciones de invierno");
		viajes.addMiembro(n2);
		
		Noticia n3 = new Noticia("Recital");
		n3.addContenido("El indio Solari cantar� en Tandil el pr�ximo fin de semana");
		n3.addContenido("Aprovechando las vacaciones de invierno, dar� un nuevo recital en la ciudad serrana");
		ocio.addMiembro(n3);
		
		System.out.println("Busqueda 1:");
		FiltroBusqueda tandil = new FiltroPalabra("Tandil");
		ArrayList<Noticia> resultado = todasLasNoticias.buscar(tandil);
		for (Noticia n:resultado)
			System.out.println(n);
		
		System.out.println("\nBusqueda 2:");
		FiltroBusqueda tandilANDdestinos = new FiltroAnd(new FiltroPalabra("Tandil"), new FiltroPalabra("destinos"));
		resultado = todasLasNoticias.buscar(tandilANDdestinos);
		for (Noticia n:resultado)
			System.out.println(n);
	}
}
