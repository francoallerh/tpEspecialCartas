package com.faller.juegoCartas;

import java.util.ArrayList;

public class FormulaCocktail extends Formula {
private ArrayList<Formula> formulas;

	public FormulaCocktail(String nombre, double valor){
		super(nombre, valor);
		formulas=new ArrayList<Formula> ();
	}
	@Override
	public double calcular(Atributo a, double suma) {
	for(Formula f: formulas){
		suma+=f.calcular(a, suma);
	}
		return suma;
	}

}
