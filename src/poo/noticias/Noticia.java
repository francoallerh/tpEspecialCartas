package poo.noticias;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import poo.noticias.filtros.FiltroBusqueda;
import poo.noticias.vocabulario.Vocabulario;

public class Noticia extends ElementoPortal {
	
	Vocabulario palabras;

	public Noticia(String titulo) {
		super(titulo);
		palabras = new Vocabulario();
	}
	
	public void addPalabra(String palabraClave){
		palabras.agregarPalabra(palabraClave);
	}
	
	public void addContenido(String texto){
		palabras.actualizar(texto);
	}
	
	public boolean contienePalabra(String palabra){
		return palabras.frecuencia(palabra) > 0;
	}

	
	@Override
	public ArrayList<Noticia> getNoticias(String palabra) {
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		if (palabras.frecuencia(palabra)>0)
			noticias.add(this);
		return noticias;
	}

	@Override
	public ArrayList<Noticia> buscar(FiltroBusqueda filtro) {
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		if (filtro.cumple(this))
			noticias.add(this);
		return noticias;
	}
	
	@Override
	public String toString(){
		return this.getTitulo()+" -> \""+palabras.toString()+"\"";
	}

}
