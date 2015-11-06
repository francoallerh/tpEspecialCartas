package com.faller.juegoCartas;

import java.util.ArrayList;

public class PocimaCocktail extends PocimaGenerica {
private ArrayList<PocimaGenerica> pociones;

	public PocimaCocktail(String nombre,PocimaGenerica pg ){
		super(nombre);
		pociones=new ArrayList<PocimaGenerica> ();
//		pociones.add(new PosimaNoCompuesta("cualca",0.0));
		pociones.add(pg);
	}
	public PocimaCocktail(String nombre) {
		super(nombre);
		pociones=new ArrayList<PocimaGenerica> ();
	}
	
	@Override
	public void calcular(Atributo a) {
		for(PocimaGenerica f: pociones){
		 f.calcular(a);
		}	
	}

	public void agregarPosion(PocimaGenerica pg){
		pociones.add(pg);
	}
	
	public PocimaGenerica miCopiar(){
		PocimaCocktail pcopy= new PocimaCocktail(super.getNombre());
		for(PocimaGenerica p:pociones){
			pcopy.agregarPosion(p);
		}
		return pcopy;
	}
}
