package com.faller.juegoCartas;

import java.util.ArrayList;

public class PosimaCocktail extends Posima {
private ArrayList<Posima> formulas;

	public PosimaCocktail(String nombre, double valor){
		super(nombre, valor);
		formulas=new ArrayList<Posima> ();
	}
	@Override
	public double calcular(Atributo a, double suma) {
	for(Posima f: formulas){
		suma+=f.calcular(a, suma);
	}
		return suma;
	}

}
