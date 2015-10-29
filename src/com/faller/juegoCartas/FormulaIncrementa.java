package com.faller.juegoCartas;

public class FormulaIncrementa extends Formula {

	@Override
	public double calcular(Atributo a, double suma) {
		return suma=a.getValor()+(a.getValor()*super.getValor()/100);

	}

}
