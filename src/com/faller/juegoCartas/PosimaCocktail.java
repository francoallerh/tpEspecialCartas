package com.faller.juegoCartas;

import java.util.ArrayList;

public class PosimaCocktail extends PosimaGenerica {
private ArrayList<PosimaGenerica> pociones;

	public PosimaCocktail(String nombre){
		super(nombre);
		pociones=new ArrayList<PosimaGenerica> ();
		pociones.add(new PosimaNoCompuesta("cualca",0.0));
		
	}
	@Override
	public void calcular(Atributo a) {
	for(PosimaGenerica f: pociones){
	 f.calcular(a);
	}
		
	}

}
