package com.faller.juegoCartas;

public class PosimaIncrementa extends Posima {

	public PosimaIncrementa(String nombre, Double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcular(Atributo a, double suma) {
		return suma=a.getValor()+(a.getValor()*super.getValor()/100);

	}

}
