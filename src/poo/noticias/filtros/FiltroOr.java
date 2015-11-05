package poo.noticias.filtros;

import poo.noticias.Noticia;

public class FiltroOr implements FiltroBusqueda{
	FiltroBusqueda filtro1;
	FiltroBusqueda filtro2;
	
	public FiltroOr(FiltroBusqueda f1, FiltroBusqueda f2){
		this.filtro1 = f1;
		this.filtro2 = f2;
	}

	@Override
	public boolean cumple(Noticia n) {
		return filtro1.cumple(n) || filtro2.cumple(n);
	}
	

}
