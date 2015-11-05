package poo.noticias;

import java.util.ArrayList;

import poo.noticias.filtros.FiltroBusqueda;

public abstract class ElementoPortal {
	private String titulo;
	
	public ElementoPortal(String titulo){
		this.titulo = titulo;
	}
	
	public abstract ArrayList<Noticia> getNoticias(String palabra);
	
	public String getTitulo(){
		return titulo;
	}
	
	public abstract ArrayList<Noticia> buscar(FiltroBusqueda filtro);

}
