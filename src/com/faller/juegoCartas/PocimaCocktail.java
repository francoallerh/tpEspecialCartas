package com.faller.juegoCartas;

import java.util.ArrayList;

public class PocimaCocktail extends PocionGenerica {
private ArrayList<PocionGenerica> pociones;

	public PocimaCocktail(String nombre,PocionGenerica pg ){
		super(nombre);
		pociones=new ArrayList<PocionGenerica> ();
//		pociones.add(new PosimaNoCompuesta("cualca",0.0));
		pociones.add(pg);
	}
	@Override
	public void calcular(Atributo a) {
		for(PocionGenerica f: pociones){
		 f.calcular(a);
		}	
	}

	public void agregarPosion(PocionGenerica pg){
		pociones.add(pg);
	}
	
	
}
