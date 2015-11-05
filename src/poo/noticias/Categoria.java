package poo.noticias;

import java.util.ArrayList;

import poo.noticias.filtros.FiltroBusqueda;

public class Categoria extends ElementoPortal {

	ArrayList<ElementoPortal> miembros;
	
	public Categoria(String titulo) {
		super(titulo);
		miembros = new ArrayList<ElementoPortal>();
	}
	
	public void addMiembro(ElementoPortal e){
		this.miembros.add(e);
	}
	
	@Override
	public ArrayList<Noticia> getNoticias(String palabra) {
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		for (ElementoPortal miembro:miembros){
			noticias.addAll(miembro.getNoticias(palabra));
		}
		return noticias;
	}

	@Override
	public ArrayList<Noticia> buscar(FiltroBusqueda filtro) {
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		for (ElementoPortal miembro:miembros){
			noticias.addAll(miembro.buscar(filtro));
		}
		return noticias;
	}

}
