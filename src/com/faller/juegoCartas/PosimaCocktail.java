package com.faller.juegoCartas;

import java.util.ArrayList;

public class PosimaCocktail extends PosionGenerica {
private ArrayList<PosionGenerica> pociones;

	public PosimaCocktail(String nombre,PosionGenerica pg ){
		super(nombre);
		pociones=new ArrayList<PosionGenerica> ();
//		pociones.add(new PosimaNoCompuesta("cualca",0.0));
		pociones.add(pg);
	}
	@Override
	public void calcular(Atributo a) {
		for(PosionGenerica f: pociones){
		 f.calcular(a);
		}	
	}

	public void agregarPosion(PosionGenerica pg){
		pociones.add(pg);
	}
	
	
}
