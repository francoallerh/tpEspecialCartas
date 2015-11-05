package poo.noticias.filtros;

import poo.noticias.Noticia;


public class FiltroTitulo implements FiltroBusqueda{
	String palabra;
	
	public FiltroTitulo(String palabra) {
		this.palabra = palabra;
	}

	@Override
	public boolean cumple(Noticia n) {
		return n.getTitulo().contains(this.palabra);
	}
	
}
