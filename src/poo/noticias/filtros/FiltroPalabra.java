package poo.noticias.filtros;

import poo.noticias.Noticia;


public class FiltroPalabra implements FiltroBusqueda{
	String palabra;
	
	public FiltroPalabra(String palabra) {
		this.palabra = palabra;
	}

	@Override
	public boolean cumple(Noticia n) {
		return n.contienePalabra(this.palabra);
	}
	
	
}
